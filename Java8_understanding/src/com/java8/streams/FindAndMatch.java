package com.java8.streams;

public class FindAndMatch {

    public static void main(String[] args) {

        if(Dish.menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("You have vegiteran item");
        }

        boolean isHeathy = Dish.menu.stream().allMatch(dish -> dish.getCalories() < 1000);
        System.out.println("is all dishes healthy ? "+isHeathy);

        boolean isHealthy2 = Dish.menu.stream().noneMatch(dish -> dish.getCalories() >=1000);
        System.out.println("is dishes healthy 2"+isHealthy2);

        
    }
}
