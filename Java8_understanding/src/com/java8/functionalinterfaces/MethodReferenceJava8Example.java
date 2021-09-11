package com.java8.functionalinterfaces;

import java.util.function.UnaryOperator;

public class MethodReferenceJava8Example {

    public static void main(String[] args) {

        String testString1 = "THis is NEW TEst 1 StriNG";
        String testString2 = "THis is NEW TEst 2 StriNG";

        // UnartOperator is functional interface which accepts one argument and returns result with same argument type.
        UnaryOperator<String> makeStringUpperCaseWithlambda = (s) -> s.toUpperCase();
        UnaryOperator<String> makeStringUpperCaseWithMethodReference = String::toUpperCase;

        System.out.println("testString1 making it upper case with lambda function : "+makeStringUpperCaseWithlambda.apply(testString1));
        System.out.println("testString2 making it upper case with method reference : "+makeStringUpperCaseWithMethodReference.apply(testString2));

    }
}
