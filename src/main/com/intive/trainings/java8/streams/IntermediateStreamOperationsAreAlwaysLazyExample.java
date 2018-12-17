package com.intive.trainings.java8.streams;

import com.intive.trainings.java8.Game;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermediateStreamOperationsAreAlwaysLazyExample {

    public static void main(String[] args) {
        // #2 laziness example
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

        List<String> collected = notTerminated.collect(Collectors.toList());
        System.out.println(collected);

        // #2 another flatmap example
        List<? extends Comparable<? extends Comparable<?>>> list =
                Stream.of(
                        new Game("name2", LocalDate.MAX, 11),
                        new Game("name3", LocalDate.MIN, 1111))
                .flatMap(game -> Stream.of(game.getFirstRun(), game.getName(), game.getRank()))
                .collect(Collectors.toList());
        System.out.println(list);
    }
}
