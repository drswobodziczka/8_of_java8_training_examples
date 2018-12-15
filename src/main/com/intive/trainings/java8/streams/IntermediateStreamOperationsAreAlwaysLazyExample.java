package com.intive.trainings.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermediateStreamOperationsAreAlwaysLazyExample {

    public static void main(String[] args) {
        Stream<String> notTerminated = Stream.of("a", "bvvvvv", "a", "ccc", "nike", "alamandra", "who is alice?", "come with me if you'd like to live", "tiny", "s")
                .distinct()
                .sorted()
                .map(elem -> {
                    System.out.println("mapping: " + elem + " to lowercase..");
                    return elem.toLowerCase();
                })
                .filter(elem -> {
                    System.out.println(elem + " is long enough");
                    return elem.length() > 5;
                })
                .flatMap(str -> {
                    System.out.println("tokenizing string: " + str);
                    return str.codePoints().mapToObj(c -> String.valueOf((char) c));
                });

//        List<String> collected = notTerminated.collect(Collectors.toList());
    }


}
