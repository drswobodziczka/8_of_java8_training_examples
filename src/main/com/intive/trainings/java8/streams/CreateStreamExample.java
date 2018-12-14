package com.intive.trainings.java8.streams;

import java.util.*;
import java.util.stream.Stream;

public class CreateStreamExample {

    Stream<String> createEmptyStream() {
        return Stream.empty();
    }

    Stream<String> createStreamFromArray() {
        String[] array = new String[] {"a", "b", "c"};

        return Arrays.stream(array);
    }

    Stream<String> createStreamFromCollection() {
        String[] array = new String[] {"a", "b", "c"};
        List<String> strings = Arrays.asList(array);

        Stream<String> streamOfList = strings.stream();
        Stream<String> streamOfSet = new HashSet<>(strings).stream();

        return streamOfList;
    }
}
