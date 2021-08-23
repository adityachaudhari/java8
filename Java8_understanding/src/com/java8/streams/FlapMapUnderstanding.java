package com.java8.streams;

import jdk.internal.util.xml.impl.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlapMapUnderstanding {

    public static void main(String[] args) {

        String testString1 = "Hello";
        String testString2 = "World";
        List<String> listOfString = new ArrayList<>();
        listOfString.add(testString1);
        listOfString.add(testString2);
        List<String> uniqueCharacters = listOfString.stream().map(w -> w.split("")).flatMap(Arrays::stream)
                .distinct().collect(Collectors.toList());

        uniqueCharacters.forEach(element-> System.out.print(element+" "));

        System.out.println(" ");
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        List<Integer> sqOfNumbers = numbers.stream().map(number -> number*number).collect(Collectors.toList());
        sqOfNumbers.forEach(num -> System.out.print(num+" "));

        System.out.println(" ");
        // input [1,2,3] and [3,4] output [(1,3),(1,4),(2,3),(2,4),(3,3),(3,4)]
        List<Integer> list1 = Arrays.asList(1,2,3);
        List<Integer> list2 = Arrays.asList(3,4);
        List<int[]> pairs = list1.stream().flatMap(i -> list2.stream().map(j -> new int[]{i,j})).collect(Collectors.toList());
        //pairs.forEach(e);
        pairs.forEach(num -> System.out.print(num+" "));

    }
}
