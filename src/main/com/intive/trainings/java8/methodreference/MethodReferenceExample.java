package com.intive.trainings.java8.methodreference;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;

import static java.lang.System.out;

public class MethodReferenceExample {

    private int method(int i, int y, int z, int x) {
        return 2;
    }

    @FunctionalInterface
    interface MultiFunction<A, B, C, D, E> {
        E func(A a, B b, C c, D d);
    }

    public static void main(String[] args) {
        // #1 static method reference
        Function<Integer, String> valueOfIntLambda = (i) -> String.valueOf(i);
        Function<Integer, String> valueOfIntMethodReference = String::valueOf;

        // #2 method reference to an instance method of an existing object
        MethodReferenceExample example = new MethodReferenceExample();
        MultiFunction<Integer, Integer, Integer, Integer, Integer> f = example::method;

        // #3 method references to instance methods of an object of a particular type
        BiFunction<String, String, String[]> split = String::split;
        BiFunction<String, String, Boolean> startsWith = String::startsWith;
        out.println(startsWith.apply("ala ma kota", "ala"));
        out.println(Arrays.toString(split.apply("ala ma kota", " ")));

        // #4 constructor reference
        Function<String, String> constructor = String::new;
        String ala_ma_kota = constructor.apply("ala ma kota");
        out.println(ala_ma_kota);
    }
}

