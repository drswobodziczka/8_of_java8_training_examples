package com.intive.trainings.java8.optionals;

import java.util.Optional;

public class DefaultValuesExample {

    public static void main(String[] args) {
        Optional<String> empty = Optional.empty();

        // #1 or else..
        String value = empty.orElse("ala ma kota");
        System.out.println(value);

        // #2 or else get - called
        String valueFromSupplier = empty.orElseGet(() -> {
            System.out.println("Tu bylem, Tony Halik!");
            return "ala ma kota";
        });
        System.out.println(valueFromSupplier);

        // #3 or else get - not called
        valueFromSupplier = Optional.of("ale ala ma już kota").orElseGet(() -> {
            System.out.println("not reachable will not appear..");
            return "ala ma kota";
        });
        System.out.println(valueFromSupplier);

        // #4 throw if empty!
        try {
            empty.orElseThrow(RuntimeException::new);
        } catch (RuntimeException e) {
            System.out.println(e);
        }
    }
}
