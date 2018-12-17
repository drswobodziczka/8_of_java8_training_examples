package com.intive.trainings.java8.optionals;

import java.util.Optional;

public class HowToCreateOptionalExample {

    public static void main(String[] args) {
        // #1 empty
        Optional<Integer> integer = Optional.empty();

        assert !integer.isPresent();

        // #2, of, null -> NPE
        String nullString = null;
        Optional<String> willNotHappen = Optional.of(nullString);

        // #3 of, if present
        String string = "some";
        Optional<String> optionalS = Optional.of(string);
        optionalS.ifPresent(System.out::println);

        // #4 ofNullable
        Optional<String> optional = Optional.ofNullable(null);
        String replacement = optional.orElse("replacement");
        System.out.println(replacement);

    }
}
