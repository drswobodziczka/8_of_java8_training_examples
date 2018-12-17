package com.intive.trainings.java8.functionalIntf;

import java.nio.file.DirectoryStream;
import java.util.Random;
import java.util.function.*;

public class JavaUtilFunctionExamples {

    public static void main(String[] args) {

        // # 1 function example
        Function<String, Integer> function = a -> a.length();

        // #2
        Supplier<Integer> supplier = () -> new Random().nextInt();

        // #3
        Consumer<String> consumer = (a) -> {
            System.out.println(a);
        };

        // #4
        Predicate<String> first = ((Predicate<String>) string -> string.split(" ").length > 2);
        System.out.println(first.test("ala ma kota"));

        Predicate<String> second = first.and(str -> str.length() > 100).and(str -> str.contains("ala"));
        System.out.println(second.test("ala ma kota"));

        Predicate<String> third = first.or(str -> str.contains("kotaasdasdasdas"));
        System.out.println(third.test("ala ma kota"));
        System.out.println(third
                .negate()
                .test("ala ma kota"));

    }

}
