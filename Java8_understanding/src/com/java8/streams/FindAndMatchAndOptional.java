package com.java8.streams;

import java.util.Optional;

public class FindAndMatchAndOptional {

    public static void main(String[] args) {

        if(Dish.menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("You have vegiteran item");
        }

        boolean isHeathy = Dish.menu.stream().allMatch(dish -> dish.getCalories() < 1000);
        System.out.println("is all dishes healthy ? "+isHeathy);

        boolean isHealthy2 = Dish.menu.stream().noneMatch(dish -> dish.getCalories() >=1000);
        System.out.println("is dishes healthy 2"+isHealthy2);

        // findAny example remember findAny returns Optional
        Optional<Dish> getAnyVegiterialDish = Dish.menu.stream().filter(Dish::isVegetarian).findAny();

        // if any vegiterian dish found return that dish name
        Dish.menu.stream().filter(Dish::isVegetarian).findFirst().ifPresent(dish -> System.out.println(dish.getName()));


    }
}
