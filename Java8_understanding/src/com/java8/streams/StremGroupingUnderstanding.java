package com.java8.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StremGroupingUnderstanding {
    public static void main(String[] args) {

        Map<Dish.Type, List<Dish>> dishesByType = Dish.menu.stream().collect(Collectors.groupingBy(Dish::getType));
        System.out.println("grouping dishes by type :"+dishesByType);

        // multilevel grouping TODO 174 page no.

        // partition by example
        Map<Boolean, List<Dish>> partitionedMenu = Dish.menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian));
        System.out.println("partitioned menu :"+partitionedMenu);

        System.out.println("vegiterian menu :"+partitionedMenu.get(true));

    }
}
