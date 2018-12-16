package com.intive.trainings.java8.streams;

import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.toList;

public class CreateStreamExample {

    void createEmptyStream() {
        Stream<Object> empty = Stream.empty();
        printStream(empty);
    }

    void createStreamFromArray() {
        String[] array = new String[]{"a", "b", "c"};
        Stream<String> stream = Arrays.stream(array);
        printStream(stream);
    }

    void createStreamFromCollection() {
        Stream<String> stream = Arrays.asList("a", "b", "c").stream();
        printStream(stream);
    }

    private void createStreamFromFactoryMethods() {
        //
        Stream<String> factoryStream = Stream.of("ala", "ma", "kota");

        //
        Stream<Double> iteratedStream = Stream.iterate(2.0, Math::exp).limit(100);

        //
        DoubleStream doubleStream = DoubleStream.generate(() -> new Random().nextDouble());
        Stream<String> alaStream = Stream.generate(() -> "ala ma kota").limit(10);

        //
        IntStream intStream = IntStream.range(0, 100);

        printStream(factoryStream);
        printStream(iteratedStream);
        printStream(doubleStream.boxed());
        printStream(alaStream);
        printStream(intStream.boxed());
    }

    void createStreamFromRandom() {
        IntStream ints = new Random().ints();
        DoubleStream doubles = new Random().doubles();

        printStream(doubles.boxed());
        printStream(ints.boxed());
    }

    void createStreamFromStreamBuilder() {
        Stream<String> stream = Stream.<String>builder()
                .add("ala")
                .add("ma")
                .add("kota")
                .build();

        printStream(stream);
    }

    private void printStream(Stream<?> stream) {
        System.out.println(stream.collect(toList()));
    }

    public static void main(String[] args) {
        CreateStreamExample createStreamExample = new CreateStreamExample();

        createStreamExample.createEmptyStream();
        createStreamExample.createStreamFromArray();
        createStreamExample.createStreamFromCollection();
        createStreamExample.createStreamFromFactoryMethods();
        createStreamExample.createStreamFromRandom();
        createStreamExample.createStreamFromStreamBuilder();
    }
}
