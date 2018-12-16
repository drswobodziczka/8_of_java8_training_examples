package com.intive.trainings.java8.methodreference;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static java.lang.System.out;

public class MethodReferenceExample {


    private void doSmthWithMe(String input, Function<String, ?> consumer) {
        out.println(consumer.apply(input));
        Supplier<String> runnable = String::new;
        runnable.get();
    }

    private static String createMe(Supplier<String> supplier) {
        BiFunction<String, String, String[]> stringStringBiFunction = String::split;
        BiFunction<String, String, Boolean> stringStringBooleanBiFunction = String::startsWith;
        Function<Integer, String> converter = String::valueOf;
        Function<String, String> constructor = String::new;
        Function<String, Object> runnable1 = String::new;

        return supplier.get();
    }

    private static int method(int i, int y, int z, int x) {
        return 2;
    }

    @FunctionalInterface
    interface MultiFunction<A, B, C, D, E> {
        E func(A a, B b, C c, D d);
    }

    public static void main(String[] args) {
        Function<Integer, String> valueOfIntLambda = (i) -> String.valueOf(i);

        Function<Integer, String> valueOfIntMethodReference = String::valueOf;

        // zeby wyciagnac method refernce, musze miec odpowiedni typ interfejsu funkcyjnego
        MultiFunction<Integer, Integer, Integer, Integer, Integer> f = MethodReferenceExample::method;

        assert Objects.equals(valueOfIntLambda.apply(4), valueOfIntMethodReference.apply(4));
    }
}

