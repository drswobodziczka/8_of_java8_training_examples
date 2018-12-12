package com.intive.trainings.java8.lambdas;

public class MultiparameterLambdaExample {

    interface Function<A, B, C, D, E> {
        E apply(A a, B b, C c, D d);
    }

    public static void main(String[] args) {
        Function<Integer, String, Double, Boolean, Integer> multiparamFunction = (a, b, c, d) -> 2;
    }
}
