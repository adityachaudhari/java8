package com.java8.functionalinterfaces;

import java.util.function.Function;

public class ComposingFunction {

    // has methds  andThen and compose both returns an instance of function
    public static void main(String[] args) {

        Function<Integer, Integer> incrementNumberByOne = (number) -> number + 1;
        Function<Integer, Integer> multiplyByTwo = (number) -> number * 2;
        Function<Integer, Integer> thenExample = incrementNumberByOne.andThen(multiplyByTwo);
        Function<Integer, Integer> composeExample = incrementNumberByOne.compose(multiplyByTwo);

        // and then example
        int andThenResult = thenExample.apply(1);
        System.out.println("1 number incremented by 1 and then multiply by 2 the result is : "+andThenResult);

        // compose example
        int composeResult = composeExample.apply(1);
        System.out.println("1 number multiply by 2 and then increment by 1 the result is : "+composeResult);
    }
}
