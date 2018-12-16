package com.intive.trainings.java8.streams;

import java.util.Arrays;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class CreateStreamExample {

    private void createEmptyStream() {
        Stream<Object> empty = Stream.empty();
        printStream(empty);
    }

    private void createStreamFromArray() {
        String[] array = new String[]{"a", "b", "c"};
        Stream<String> stream = Arrays.stream(array);
        printStream(stream);
    }

    private void createStreamFromCollection() {
        Stream<String> stream = Arrays.asList("a", "b", "c").stream();
        printStream(stream);
    }

    private void createStreamFromFactoryMethods() {
        //
        Stream<String> factoryStream = Stream.of("ala", "ma", "kota");

        //
        Stream<Double> iteratedStream = Stream.iterate(2.0, Math::exp).limit(10);

        //
        DoubleStream doubleStream = DoubleStream.generate(() -> new Random().nextDouble()).limit(10);
        Stream<String> alaStream = Stream.generate(() -> "ala ma kota").limit(10);

        //
        IntStream intStream = IntStream.range(0, 100);

        printStream(factoryStream);
        printStream(iteratedStream);
        printStream(doubleStream.boxed());
        printStream(alaStream);
        printStream(intStream.boxed());
    }

    private void createStreamFromRandom() {
        IntStream ints = new Random().ints().limit(10);
        DoubleStream doubles = new Random().doubles().limit(10);

        printStream(doubles.boxed());
        printStream(ints.boxed());
    }

    private void createStreamFromStreamBuilder() {
        Stream<String> stream = Stream.<String>builder()
                .add("ala")
                .add("ma")
                .add("kota")
                .build();

        printStream(stream);
    }

    private void createStreamFromString() {
        //
        Stream<String> streamOfString =
                Pattern.compile(", ").splitAsStream("a, b, c, d, e, f");
        printStream(streamOfString);

        //
        IntStream chars = "ala ma kota".chars();
        printStream(chars.boxed());

        //
        Stream<String> stringStream = "ala ma kota".codePoints().mapToObj(c -> String.valueOf((char) c));
        printStream(stringStream);
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
        createStreamExample.createStreamFromString();
    }
}
