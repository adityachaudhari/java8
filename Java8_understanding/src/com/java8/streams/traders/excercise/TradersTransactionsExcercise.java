package com.java8.streams.traders.excercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// A stream excercise from java 8 in action book
public class TradersTransactionsExcercise {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300), new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400), new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));

        System.out.println("Find all transactions in the year 2011 and sort them by value (small to high)");
        transactions.stream()
                .filter(tran -> tran.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue)).forEach(tran -> System.out.println(tran));

        System.out.println("\nwhat are all unique cities where the traders work?");
        transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct().forEach(city -> System.out.print(city + ", "));

        System.out.println("\n\nFind all traders from Cambridge and sort them by name.");
        transactions.stream().map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName)).forEach(trader -> System.out.print(trader + ", "));

        System.out.println("\n\nReturn a string of all traders names sorted alphabetically.");
        transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted().forEach(trader -> System.out.print(trader));


        String stringOfAllTradersUsingReduce = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("",(n1,n2) -> n1+n2);
        System.out.println("\nstring of all traders using reduce :" +stringOfAllTradersUsingReduce);

        String stringOfAllTradersUsingJoining = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining());
        System.out.println("\nstring of all traders :" +stringOfAllTradersUsingJoining);


        System.out.println("\n\nAre any traders based in Milan?");
       // transactions.stream().map(Transaction::getTrader).filter(trader -> trader.getCity() == "Milan").findAny().ifPresent(trader -> System.out.println(trader));
        boolean milanBased = transactions.stream().anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        System.out.println(milanBased);

        System.out.println("\n\n Print all transactions values from the traders living in Cambridge");
        transactions.stream().filter(transaction -> transaction.getTrader().getCity().equals("Cambridge")).forEach(transaction -> System.out.print(transaction));

        System.out.println("\n\n What’s the highest value of all the transactions?");
        //transactions.stream().map(transaction -> transaction.getValue()).distinct().max(Integer::compareTo).ifPresent(integer -> System.out.println(integer.intValue()));
        Optional<Integer> highestValue = transactions.stream().map(Transaction::getValue).reduce(Integer::max);
        System.out.println(highestValue.get());

        System.out.println("\n\n Find the transaction with the smallest value using mapToInt");
        transactions.stream().mapToInt(transaction -> transaction.getValue()).min().ifPresent(integer -> System.out.println(integer));

        System.out.println("\n\n Find the transaction with the smallest value using reduce its and returning Transaction object instead value");
        Optional<Transaction> minTransaction = transactions.stream().reduce((t1,t2) -> t1.getValue() < t2.getValue() ? t1 : t2);
        System.out.println(minTransaction.get());

    }
}
