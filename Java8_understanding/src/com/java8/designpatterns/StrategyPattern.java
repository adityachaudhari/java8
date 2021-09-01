package com.java8.designpatterns;

import java.util.Arrays;
import java.util.List;

// implementing validation strategy
public class StrategyPattern {

    public static void main(String[] args) {
        String stringToValidate = "SSSSSGGFGFGG";

        // old school validators
        List<ValidatorStrategy> oldSchoolValidators = Arrays.asList(new isNotEmptyCheck(), new isUpperCase(), new containsSpecialChar());

       System.out.println("\nexecuting validators using OLD java way");
        for (ValidatorStrategy v : oldSchoolValidators) {
            v.validate(stringToValidate);
        }

        // java 8 validators
        Validator v1_IsNotEmptyCheck = new Validator((String s) -> !s.isEmpty());
        Validator v2_IsUpperCase = new Validator((String s) -> s.toUpperCase().equals(s));
        Validator v3_ContainsSpecialChar = new Validator((String s) -> {
            List<Character> specialCharList = Arrays.asList('%', '#');
            char[] charArray = s.toCharArray();
            for (char chr : charArray) {
                if (specialCharList.contains(chr)) {
                    return true;
                }
            }
            return false;
        });

        System.out.println("\nexecuting validators using java 8 way");
        for (Validator java8Validator : Arrays.asList(v1_IsNotEmptyCheck, v2_IsUpperCase, v3_ContainsSpecialChar)) {
            java8Validator.validate("sfsdfsfsdf");
        }
    }
}

interface ValidatorStrategy {
    boolean validate(String s);
}

class isNotEmptyCheck implements ValidatorStrategy {
    @Override public boolean validate(final String s) {
        System.out.println("executed isNotEmptyCheck");
        return !s.isEmpty();
    }
}

class isUpperCase implements ValidatorStrategy {
    @Override public boolean validate(String s) {
        System.out.println("executed isUpperCase");
        return s.toUpperCase().equals(s);
    }
}

class containsSpecialChar implements ValidatorStrategy {
    @Override public boolean validate(String s) {
        List<Character> specialCharList = Arrays.asList('%', '#');
        char[] charArray = s.toCharArray();
        for (char chr : charArray) {
            if (specialCharList.contains(chr)) {
                return true;
            }
        }
        System.out.println("executed containsSpecialChar");
        return false;
    }
}

class Validator {
    private final ValidatorStrategy strategy;

    public Validator(ValidatorStrategy vs) {
        this.strategy = vs;
    }

    public boolean validate(String s) {
        System.out.println("executing java 8 style strategy validators for strategy :"+this.strategy.toString());
        return strategy.validate(s);
    }
}
