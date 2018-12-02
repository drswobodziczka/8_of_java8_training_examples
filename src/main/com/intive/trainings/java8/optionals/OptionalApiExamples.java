package com.intive.trainings.java8.optionals;

import java.util.Optional;

public class OptionalApiExamples {

    public static void main(String[] args) {
        Optional<Integer> integer = Optional
                .of(10)
                .map(opt -> opt)
                .filter(value -> value > 5);
    }
}
