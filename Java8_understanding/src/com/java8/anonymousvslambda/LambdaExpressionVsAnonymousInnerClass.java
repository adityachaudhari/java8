package com.java8.anonymousvslambda;

public class LambdaExpressionVsAnonymousInnerClass {

    public static void main(String[] args) {

        // anonymous inner class
        Runnable runnableAnonymous = new Runnable() {
            @Override
            public void run() {
                System.out.println("From Anonymous inner class");
            }
        };

        // lambda expression
        Runnable runnableLamdba = () -> {
          System.out.println("From lamdba expression");
        };

        new Thread(runnableAnonymous).start();
        new Thread(runnableLamdba).start();
    }
}
