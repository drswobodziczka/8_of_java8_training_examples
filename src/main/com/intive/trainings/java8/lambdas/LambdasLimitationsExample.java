package com.intive.trainings.java8.lambdas;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class LambdasLimitationsExample {

    public static void main(String[] args) {
        // #1 variable from parent scope should be final or effectively final
        String prefix = "ma kota";
//        prefix = "albo nie ma";
        BiFunction<Integer, Integer, String> function = (a, b) -> {
            if (a >= b) {
                return prefix + a;
            }
            return prefix + b;
        };

        //
        try {
            Consumer<String> as = (a) -> {
                throw new RuntimeException();
            };
        } catch (Exception e) {
            e.printStackTrace();
        }

        int i = 0;
        Consumer<String> as = (a) -> {
            System.out.println(i);
            throw new RuntimeException();
        };
    }
}
