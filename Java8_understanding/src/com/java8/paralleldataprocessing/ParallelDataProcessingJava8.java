package com.java8.paralleldataprocessing;

import java.util.function.Function;
import java.util.stream.Stream;

public class ParallelDataProcessingJava8 {

    public static void main(String[] args) {
        System.out.println("runtime threads : " + Runtime.getRuntime().availableProcessors());
        /*System.out.println("Sequential sum for 100 nos  with java 8 without parallel stream is "+ iterativeSum(4));
        System.out.println("Sequential sum for 100 nos  with java 8 with  parallel stream is "+ parallelSum(4));*/


        boolean hasAnyEmptyString = Stream.of("String1", "String2", "String3", "String4", "").parallel()
                .anyMatch(String::isEmpty);
        System.out.println("string of list has any empty string ? "+hasAnyEmptyString);

        System.out.println("\nSequential sum for 1_000_00000 nos  with java 8 without parallel stream done in " +
                measureSumPerf(ParallelDataProcessingJava8::iterativeSum, 10_000_00) + " msecs");

        System.out.println(" \nSequential sum for 1_000_00000 nos  with java 8 with parallel stream done in " +
                measureSumPerf(ParallelDataProcessingJava8::parallelSum, 10_000_00) + " msecs");

    }

    public static long iterativeSum(long n) {
        return Stream.iterate(1L, i -> i+1)
                .limit(n)
                .reduce(0L, Long::sum);
    }

    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i+1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
    }

    public static long iterativeSumTraditionalForLoop(long n) {
        long result = 0;
        for (long i = 1L; i <= n; i++) {
            result += i;
        }
        return result;
    }

    public static long measureSumPerf(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_00000;
           // System.out.println("Result: " + sum);
            if (duration < fastest) fastest = duration;
        }
        return fastest;
    }
}
