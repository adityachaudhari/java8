package com.java8.designpatterns.TemplatePattern;

import java.util.function.Consumer;

// reference java 8 in action book
public class OnlineBankingLambda {

    public static void main(String[] args) {
        new OnlineBankingLambda().processCustomer(1337, (Customer c) -> System.out.println("Hello!"));
    }

    public void processCustomer(int id, Consumer<Customer> makeCustomerHappy) {
        Customer c = Database.getCustomerWithId(id);
        makeCustomerHappy.accept(c);
    }

    // dummy Customer class
    static private class Customer {
    }

    // dummy Database class
    static private class Database {
        static Customer getCustomerWithId(int id) {
            return new Customer();
        }
    }
}
