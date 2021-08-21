package com.java8.comparator;

import com.java8.behaviourparameterization.Apple;
import com.java8.behaviourparameterization.Color;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ChainingComparatorJava8 {

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

        System.out.println("List of apples before any sorting applied");
        printApplesList(listOfApples);
        // First filter by color if color is same
        listOfApples.sort(Comparator.comparing(Apple::getColor));
        System.out.println("\nList of apples with color sorting");
        printApplesList(listOfApples);

        System.out.println("\nList of apples with color sorting and if color is same sorting by weight");
        listOfApples.sort(Comparator.comparing(Apple::getColor).thenComparing(Apple::getWeight));
        printApplesList(listOfApples);
    }

    private static void printApplesList(List<Apple> listOfApples) {
        listOfApples.forEach(apple -> {
            System.out.print(apple.getColor() + " " + apple.getWeight() + ", ");
        });
    }
}
