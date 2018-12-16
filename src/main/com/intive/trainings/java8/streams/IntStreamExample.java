package com.intive.trainings.java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntStreamExample {

    static class DummyWrapper {
        private int i;

        private DummyWrapper(int i) {
            this.i = i;
        }
    }
    public static void main(String[] args) {
        //
        IntStream intStream = IntStream.range(0, 100);
        List<Integer> listBoxed = intStream.boxed().collect(Collectors.toList());
        System.out.println(listBoxed);

        intStream = IntStream.range(0, 100);
        List<Integer> listMap = intStream.mapToObj(Integer::new).collect(Collectors.toList());
        System.out.println(listMap);

        intStream = IntStream.range(0, 100);
        List<Integer> listCollect = intStream.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println(listCollect);

        //
        intStream = IntStream.range(0, 100);
        Stream<DummyWrapper> wrapperStream = intStream.mapToObj(DummyWrapper::new);

        //
        intStream = IntStream.range(0, 100);
        int reduced = intStream.reduce(0, (a, b) -> a + b);
        System.out.println(reduced);
    }
}
