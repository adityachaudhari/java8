package com.java8.streams;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamFromValues {
    public static void main(String[] args) {

        // stream from value
        Stream<String> stream = Stream.of("This", "Is", "java8", "stream", "of", "string", "values");

        Stream<String> emptyString = Stream.empty();

        // stream from arrays
        int[] numbers = {2,3,6,8,10};
        int sum = Arrays.stream(numbers).sum();


        // stream from files TODO

    }
}
