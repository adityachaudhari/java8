package com.java8.streams;

import java.util.List;
import java.util.stream.Collectors;

public class StreamsUndetstanding {

    public static void main(String[] args) {

        // get all dishes whos calories less than 400
        List<Dish> dishesLessThan400calories = Dish.menu.stream().filter(dish -> dish.getCalories() < 400 ).collect(Collectors.toList());

        System.out.println("Printing dishes whose calories less than 400 ");
        printDishes(dishesLessThan400calories);

        // print first 2 meat dishes
        List<Dish> firstTwoMeatDishes = Dish.menu.stream().filter(dish -> dish.getType().equals(Dish.Type.MEAT)).limit(2).collect(Collectors.toList());
        System.out.println("\n \nPrinting first two meat dishes");
        printDishes(firstTwoMeatDishes);
    }

    private static void printDishes(List<Dish> dishesLessThan400calories) {
        dishesLessThan400calories.stream().forEach(dish -> System.out.print(dish.getName()+", "));
    }
}
