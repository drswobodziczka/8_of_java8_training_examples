package com.intive.trainings.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TeminalOperationsExample {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 2, 3, 5);

        //
        Object[] objects = integers.stream()
                .toArray();

        //
        Integer[] integers1 = integers.toArray(new Integer[]{});

        //
        Set<Integer> collect = integers.stream()
                .map(i -> i)
                .collect(Collectors.toSet());

        //
        Integer integer = integers.parallelStream()
                .filter(el -> el > 1)
                .findAny()
                .orElse(-1);

        System.out.println(integer);
    }
}
