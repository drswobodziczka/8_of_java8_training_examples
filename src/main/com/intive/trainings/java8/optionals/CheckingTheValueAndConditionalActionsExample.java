package com.intive.trainings.java8.optionals;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class CheckingTheValueAndConditionalActionsExample {

    public static void main(String[] args) {
        // #1 is present
        Optional<Long> present = Optional.of(22L);
        assert present.isPresent();

        // #2 ifPresent
        Set<Long> set = new HashSet<>();
        present.ifPresent(value -> {
            System.out.println(value);
            set.add(value);
        });
        assert set.contains(present.get());
    }
}
