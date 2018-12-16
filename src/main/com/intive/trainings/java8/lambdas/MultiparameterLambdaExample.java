package com.intive.trainings.java8.lambdas;

import java.util.stream.IntStream;

public class MultiparameterLambdaExample {

    /**
     * You have to define functional interface with method taking as many params as you need.
     */
    @FunctionalInterface
    interface Function<A, B, C, D, E> {
        E apply(A a, B b, C c, D d);
    }

    public static void main(String[] args) {
        /*
         * After then you you can define as many different lambdas as you want.
         * */

        Function<Integer, String, Double, Boolean, Integer> multiparamFunction =
                (a, b, c, d) -> 2;

        Function<Integer, Integer, Integer, Integer, Long> f =
                (a, b, c, d) -> (long) IntStream.of(a, b, c, d).reduce(0, (aa, bb) -> aa * 10 + bb * 100);

    }
}
