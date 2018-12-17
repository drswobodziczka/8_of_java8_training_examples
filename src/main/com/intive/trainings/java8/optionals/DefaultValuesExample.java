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

        // #6 if vs ifpresent
        String n = null;
        if(n != null) {
            // do smth
        }

        Optional.ofNullable(null)
                .ifPresent((v) -> {});

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

        // #5 map vs flatMap
        Optional.ofNullable(Optional.of("ggg")).flatMap(v -> v).get();
        Optional.ofNullable(Optional.of("ggg")).map(v -> v).get().get();
    }
}
