package com.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapAndFlapMapUnderstanding {

    public static void main(String[] args) {

        System.out.println("Map example : take string list  and return list of integers");
        List<String> listOfString = Arrays.asList("Str1", "String22", "RandomString", "AanotherRandomString");
        List<Integer> charactersInStringList = listOfString.stream().map(string -> string.length()).collect(Collectors.toList());

        charactersInStringList.forEach(element -> System.out.print(element + " "));

        System.out.println(" ");
        System.out.println("FlatMap : convert list of list of integers into single list of integers");
        List<List<Integer>> listOfListOfIntegers = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(5, 6));
        System.out.println("Printing list of list of integers before flattening" + listOfListOfIntegers);

        List<Integer> listInteger = listOfListOfIntegers.stream().flatMap(list -> list.stream()).collect(Collectors.toList());
        System.out.println("Printing list of list of integers after flattening" + listInteger);

    }
}
