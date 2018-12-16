package com.intive.trainings.java8.lambdas;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.function.*;

import static java.lang.Math.abs;

public class LambdasInDifferentContextsExample {

    static class FeedMe {
        private int field;

        FeedMe(Supplier<Integer> supplier) {
            field = supplier.get();
        }

        @Override
        public String toString() {
            return "FeedMe{" +
                    "field=" + field +
                    '}';
        }
    }

    @FunctionalInterface
    interface SupplierTheFirst<String> {
        String getMe();
    }

    @FunctionalInterface
    interface SupplierTheSecond<String> {
        String getMe();
    }

    public static void main(String[] args) {
        // #1 variable declarion
        Supplier<Integer> randomSupplier = () -> new Random().nextInt();

        // #2 and reassignement
        randomSupplier = () -> new Random().nextInt() * 15;

        // #3 lambda as return statement
        Supplier<BiFunction<Integer, Integer, Long>> addFunctionSupplier = () -> (a, b) -> (long) (a + b);

        // #4 lambda as a part of ternary operation
        Supplier<String> supplier = randomSupplier.get() > 0 ? () -> "randomized positive integer!" : () -> "randomized non-positive integer!";

        // #5 method paramater
        Integer[] array = {1, 2, 4, 5};
        Arrays.setAll(array, a -> 1);

        assert Arrays.stream(array).allMatch(a -> a == 1);
        System.out.println(Arrays.asList(array));

        // #6 constructor parameter
        FeedMe feedMe = new FeedMe(() -> {
            Random random = new Random();
            int counter = 0;
            if (random.nextInt() > 14) {
                return 1111;
            }
            else {
                while (random.nextInt() <= 14) {
                    counter++;
                }
                return counter;
            }
        });
        System.out.println(feedMe);

        // #7 lambda expressions in the cast context
        SupplierTheFirst supp = () -> "so here is my value please..";
        SupplierTheSecond supp22 = (SupplierTheSecond) supp;
        SupplierTheSecond supp333 = ((SupplierTheSecond) () -> "aha!");
    }


}
