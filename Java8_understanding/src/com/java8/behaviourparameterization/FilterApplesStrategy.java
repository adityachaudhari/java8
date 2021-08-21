package com.java8.behaviourparameterization;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FilterApplesStrategy {

    public static void main(String[] args) {

        Apple a1 = new Apple(100, Color.RED);
        Apple a2 = new Apple(140, Color.GREEN);
        Apple a3 = new Apple(105, Color.RED);
        Apple a4 = new Apple(103, Color.BROWN);
        Apple a5 = new Apple(108, Color.RED);
        Apple a6 = new Apple(140, Color.RED);
        Apple a7 = new Apple(116, Color.GREEN);
        Apple a8 = new Apple(106, Color.GREEN);
        Apple a9 = new Apple(137, Color.RED);
        Apple a10 = new Apple(117, Color.GREEN);

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

        // filter apples by RED color
        Predicate<Apple> filterByRed = (apple -> {
            return Color.RED.equals(apple.getColor());
        });

        // filter apples by GREEN color
        /*Predicate<Apple> filterByGreen = (apple -> {
            return Color.GREEN.equals(apple.getColor());
        });*/
        Predicate<Apple> filterByGreen = (apple) -> Color.GREEN.equals(apple.getColor());

        // filter apples by GREEN and weight below 120 grms
        Predicate<Apple> filterByGreenAndWrightBelow120 = (apple) -> apple.getColor().equals(Color.GREEN) && apple.getWeight() < 120;


        System.out.println("Apples list before filtering");
        printApplesList(listOfApples);

        System.out.println(" \n Filter apples by RED");
        List filteredRedApples = filterApplesByBehaviorParameterization(listOfApples, filterByRed);
        printApplesList(filteredRedApples);

        System.out.println(" \n Filter apples by GREEN");
        List filteredGreenApples = filterApplesByBehaviorParameterization(listOfApples, filterByGreen);
        printApplesList(filteredGreenApples);

        System.out.println(" \n Filter apples by GREEN and weight below 120");
        List filteredGreenApplesAndByWeightBelow120 = filterApplesByBehaviorParameterization(listOfApples, filterByGreenAndWrightBelow120);
        printApplesList(filteredGreenApplesAndByWeightBelow120);

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
