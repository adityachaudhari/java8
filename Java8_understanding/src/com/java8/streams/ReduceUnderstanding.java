package com.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceUnderstanding {

    public static void main(String[] args) {

        List<Integer> listOfNumbers = Arrays.asList(1,2,3,4,5);

        // sum of numbers without reduce
        int sum = 0;
        for(int x : listOfNumbers) {
            sum+=x;
        }
        System.out.println("sum of numbers without using reduce "+sum);

        // with using reduce
        //Integer sumOfNumbers = listOfNumbers.stream().reduce(0,(a,b) -> a+b);
        Integer sumOfNumbers = listOfNumbers.stream().reduce(0,Integer::sum);
        System.out.println("sum of numbers with reduce used : "+sumOfNumbers);

        // count no of dishes in stream using the map and reduce.
        Integer noOfDIshes = Dish.menu.stream()
                // map each dish in a stream as integer 1 if we have {Dish1.Dish2,Dish3} stream then it ll map to {1,1,1}
                .map(dish -> 1)
                .reduce(0, (a,b)->a+b);
        System.out.println("No of dishes using map and reduce : "+noOfDIshes);

        // check count implementation below
        System.out.println("No of dishes using count method on streams: "+Dish.menu.stream().count());

    }
}
