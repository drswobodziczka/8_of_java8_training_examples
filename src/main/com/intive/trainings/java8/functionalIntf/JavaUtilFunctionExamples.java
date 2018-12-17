package com.intive.trainings.java8.functionalIntf;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.*;

public class JavaUtilFunctionExamples {

    public static void main(String[] args) {

        // # 1 functions
        Function<String, Integer> function = a -> a.length();
        System.out.println(function.apply("sdlasjdlaskjdlasjdlsakjdlas"));

        // #2 suppliers
        Supplier<Integer> supplier = () -> new Random().nextInt();
        DoubleSupplier doubleSupplier = () -> new Random().nextDouble();
        System.out.println(supplier.get());
        System.out.println(doubleSupplier.getAsDouble());

        // #3 consumers
        Consumer<String> consumer = (a) -> {
            System.out.println(a);
        };
        consumer.accept("kot ma policję");
        BiConsumer<String, String> biConsumer = (a, b) -> System.out.println(a + b);
        IntConsumer intConsumer = i -> {
            new ArrayList<>().add(i);
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

        // #5
        UnaryOperator<String> identity = s -> s;
        System.out.println(identity.apply("the same"));
    }

}
