package com.java8.streams;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.stream.Collectors;

public class CollectorCollectotsAndCollectUnderstanding {

    public static void main(String[] args) {

        // Collectors Class its a final clas
        long howManyDishes = Dish.menu.stream().collect(Collectors.counting());
        System.out.println("How many dishes "+ howManyDishes);

        // find maximum and minimum value in stream
        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostCaloriesDish = Dish.menu.stream().collect(Collectors.maxBy(dishCaloriesComparator));
        System.out.println("most calories dish : "+mostCaloriesDish.get());

        // most calory dish using reducing technique
        Optional<Dish> mostCalorieDishUsingReducing = Dish.menu.stream().collect(Collectors.reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));

        // Optional<Dish> mostCalorieDish = Dish.menu.stream().reduce((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2); same can be done using this
        System.out.println("most calories dish using Collectors.reducing :"+mostCalorieDishUsingReducing.get());

        // summing all Calories
        int totalCaloriesInDishes = Dish.menu.stream().collect(Collectors.summingInt(Dish::getCalories));
        System.out.println("sum of all calories using Collectors.summingInt: "+totalCaloriesInDishes);

        int totalCaloriesUsingReduction = Dish.menu.stream().collect(Collectors.reducing(0,Dish::getCalories,(i,j) -> i+j));
        // int totalCaloriesUsingReduction = Dish.menu.stream().map(Dish::getCalories).reduce(0, (i, j) -> i + j); same can be done using this
        System.out.println("sum of all calories using Collectors.reducing :"+totalCaloriesUsingReduction);

        // average calories
        double avgCalories = Dish.menu.stream().collect(Collectors.averagingInt(Dish::getCalories));
        System.out.println("average calories : "+avgCalories);

        IntSummaryStatistics menuStatistics = Dish.menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        System.out.println("summarizing statistics :"+menuStatistics);

        // joining stream
        String shortMenu = Dish.menu.stream().map(Dish::getName).collect(Collectors.joining(", "));


        // TODO understand acual difference in Collector Collectors and Collect
        // collect is an interface which accepts Collector and Collecrots is final static class which provide multiple implementation of Collector as a static method in final class



        // Collector interface
    }
}
