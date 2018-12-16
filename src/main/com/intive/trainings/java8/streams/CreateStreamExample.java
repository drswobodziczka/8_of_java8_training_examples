package com.intive.trainings.java8.streams;

import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.toList;

public class CreateStreamExample {

    Stream<String> createEmptyStream() {
        return Stream.empty();
    }

    Stream<String> createStreamFromArray() {
        String[] array = new String[]{"a", "b", "c"};
        return Arrays.stream(array);
    }

    Stream<String> createStreamFromCollection() {
        return Arrays.asList("a", "b", "c").stream();
    }

    private void createStreamFromFactoryMethods() {
        Stream<String> factoryStream = Stream.of("ala", "ma", "kota");
        Stream<Double> iteratedStream = Stream.iterate(2.0, Math::exp).limit(100);
        DoubleStream doubleStream = DoubleStream.generate(() -> new Random().nextDouble());
        IntStream intStream = IntStream.range(0, 100);

        ArrayList<Integer> collect = intStream.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        System.out.println(factoryStream.collect(toList()));
        System.out.println(iteratedStream.collect(toList()));
        System.out.println(intStream.boxed().collect(toList()));
        System.out.println(factoryStream.collect(toList()));
    }

    private void printStream(BaseStream<String, ?> factoryStream) {

    }

    DoubleStream createStreamFromRandom() {
        IntStream ints = new Random().ints();
        DoubleStream doubles = new Random().doubles();
        return doubles;
    }

    Stream<String> createStreamFromStreamBuilder() {
        return Stream.<String>builder()
                .add("ala")
                .add("ma")
                .add("kota")
                .build();
    }

    public static void main(String[] args) {
        new CreateStreamExample().createStreamFromFactoryMethods();
    }
}
