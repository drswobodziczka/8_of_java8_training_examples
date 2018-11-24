package com.intive.trainings.java8.lambdas;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static java.lang.Math.abs;

public class LambdasExample {

    private static ArrayList<String> store = new ArrayList<>();

    private Supplier<Integer> randomNumber = new Random()::nextInt;

    private Supplier<Integer> positiveRandomNumber = () -> {
        int a = randomNumber.get();
        return abs(a);
    };

    private Function<String, String> filteredString = (str) -> {
        return str.replaceAll("a", "").toUpperCase();
    };

    private Function<String, String> filteredStringShort = (str) -> str.replaceAll("a", "").toUpperCase();

    private Consumer<String> printer = System.out::println;

    private Consumer<String> persister = (data) -> store.add(data);

    private BiConsumer<String, String> biPersister = (a, b) -> store.add(a + b);
}
