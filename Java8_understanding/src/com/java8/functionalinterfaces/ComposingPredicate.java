package com.java8.functionalinterfaces;

import com.java8.behaviourparameterization.Apple;
import com.java8.behaviourparameterization.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ComposingPredicate {

    // has three methods negate , and , or
    public static void main(String[] args) {
        Apple a1 = new Apple(100, Color.RED);
        Apple a2 = new Apple(117, Color.GREEN);
        Apple a3 = new Apple(105, Color.RED);
        Apple a4 = new Apple(103, Color.BROWN);
        Apple a5 = new Apple(108, Color.RED);
        Apple a6 = new Apple(140, Color.RED);
        Apple a7 = new Apple(116, Color.GREEN);
        Apple a8 = new Apple(106, Color.GREEN);
        Apple a9 = new Apple(137, Color.RED);
        Apple a10 = new Apple(134, Color.GREEN);

        List<Apple> listOfApples = new ArrayList<>();
        listOfApples.add(a1);
        listOfApples.add(a2);
        listOfApples.add(a3);
        listOfApples.add(a4);
        listOfApples.add(a5);
        listOfApples.add(a6);
        listOfApples.add(a7);
        listOfApples.add(a8);
        listOfApples.add(a9);
        listOfApples.add(a10);

        Predicate<Apple> redApplePredicate = (apple) -> apple.getColor().equals(Color.RED);
        System.out.println("Printing all RED apples");
        List redApples = filterApplesByBehaviorParameterization(listOfApples, redApplePredicate);
        printApplesList(redApples);

        //using negate predicate in predicate
        Predicate<Apple> notRedApples =  redApplePredicate.negate();
        List noteRedApplesList = filterApplesByBehaviorParameterization(listOfApples, notRedApples);
        System.out.println("\nPrinting non RED apples");
        printApplesList(noteRedApplesList);

        // using and in predicate
        Predicate<Apple> redAndHeavyApple =  redApplePredicate.and(apple -> apple.getWeight() > 105);
        List redAndHeavyAppleList = filterApplesByBehaviorParameterization(listOfApples, redAndHeavyApple);
        System.out.println("\nPrinting RED and heavy apples");
        printApplesList(redAndHeavyAppleList);

        // using OR in predicate
        Predicate<Apple> redAndHeavyApplesOrGreen =  redApplePredicate.and(apple -> apple.getWeight() > 105).or(apple -> apple.getColor().equals(Color.GREEN));
        List redAndHeavyApplesOrGreenList = filterApplesByBehaviorParameterization(listOfApples, redAndHeavyApple);
        System.out.println("\nPrinting RED and heavy apples OR Green");
        printApplesList(redAndHeavyApplesOrGreenList);

    }

    private static void printApplesList(List<Apple> listOfApples) {
        listOfApples.forEach(apple -> {
            System.out.print(apple.getColor() + " " + apple.getWeight() + ", ");
        });
    }

    static List<Apple> filterApplesByBehaviorParameterization(List<Apple> listOfApples, Predicate<Apple> applePredicate) {
        List<Apple> resultList = new ArrayList<>();

        listOfApples.forEach(apple -> {
            if (applePredicate.test(apple)) {
                resultList.add(apple);
            }
        });

        return resultList;
    }
}
