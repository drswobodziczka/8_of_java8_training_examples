package com.intive.trainings.java8.methodreference;

import java.io.IOException;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;

import static java.lang.System.out;

public class MethodReferenceExample {

    private int method(int i, int y, int z, int x) {
        return 2;
    }

    private int method(String str) {
        return 2;
    }

    private static int methodThrowing(String str) throws IOException {
        return 2;
    }

    @FunctionalInterface
    interface MultiFunction<A, B, C, D, E> {
        E func(A a, B b, C c, D d);
    }

    @FunctionalInterface
    interface FunctionThrowing<String, Integer> {
        Integer apply(String param) throws IOException;
    }

    public static void main(String[] args) {
        // #1 static method reference
        Function<Integer, String> valueOfIntLambda = (i) -> String.valueOf(i);
        Function<Integer, String> valueOfIntMethodReference = String::valueOf;
        BiFunction<MethodReferenceExample, String, Integer> m = MethodReferenceExample::method;

        // #2 method reference to an instance method of an existing object
        MethodReferenceExample example = new MethodReferenceExample();
        MultiFunction<Integer, Integer, Integer, Integer, Integer> f = example::method;

        // #3 method references to instance methods of an object of a particular type
        BiFunction<String, String, String[]> split = String::split;
        BiFunction<String, String, Boolean> startsWith = String::startsWith;
        out.println(Arrays.toString(split.apply("ala ma kota", " ")));
        out.println(startsWith.apply("ala ma kota", "ala"));

        // #4 constructor reference
        Function<String, String> constructor = String::new;
        String ala_ma_kota = constructor.apply("ala ma kota");
        out.println(ala_ma_kota);

        // #5 method reference throwing
        FunctionThrowing<String, Integer> methodThrowing = MethodReferenceExample::methodThrowing;

        // #6 lambda throwing exception
        FunctionThrowing<String, String> ad = (a) -> {
                throw new IOException();
        };

        // #7 private constructor not accessible
        // Supplier<Dummy> dCostr = Dummy::new;
    }
}

