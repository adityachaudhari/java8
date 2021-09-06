package com.java8.optional;

import java.util.Optional;

public class OptionalUnderstanding {

    public static void main(String[] args) {

        // creating optional objects
        Optional<Car> optCarEmptyObj = Optional.empty();
        System.out.println("Creating optional empty object : " + optCarEmptyObj);

        Car car = null;
        //optional from non null value
        /*Optional<Car> optCar = Optional.of(car);
        System.out.println("Throwing null pointer as car is null "+optCarEmptyObj);*/

        // optional from null
        Optional<Car> optCar = Optional.ofNullable(car);
        System.out.println("Not throwing null though car is null : " + optCar);

        //beow code ll throw  null pointer exception
        //System.out.println("This is throwing null pointer exception : " + optCar.get());

        // using optinal better way
        Insurance insurance = null;
        Optional<Insurance> optInsurance = Optional.ofNullable(insurance);
        Optional<String> name = optInsurance.map(Insurance::getName);
        System.out.println("insurance is null :"+name);

        // TODO 293


    }
}
