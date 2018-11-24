package com.intive.trainings.java8.lambdas;

import java.util.function.Consumer;

public class ConsumerInnerLambdaMethodReferenceExample {

    private void doSomething(Consumer<String> cmd, String param) {
        cmd.accept(param);
    }

    public static void main(String[] args) {
        printString("string");
    }

    private static void printString(String string) {
        ConsumerInnerLambdaMethodReferenceExample lambdasExample = new ConsumerInnerLambdaMethodReferenceExample();
        lambdasExample.doSomething(new Consumer<String>() {
            @Override
            public void accept(String param) {
                System.out.println(param);
            }
        }, string);
    }

    private static void printStringLambda(String string) {
        ConsumerInnerLambdaMethodReferenceExample lambdasExample = new ConsumerInnerLambdaMethodReferenceExample();
        lambdasExample.doSomething(param -> System.out.println(param), string);
    }

    private static void printStringMethodReference(String string) {
        ConsumerInnerLambdaMethodReferenceExample lambdasExample = new ConsumerInnerLambdaMethodReferenceExample();
        lambdasExample.doSomething(System.out::println, string);
    }
}
