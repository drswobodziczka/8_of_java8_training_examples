package com.intive.trainings.java8.lambdas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class StringCommandsExecutorLambdas {

    private void execute(Consumer<String> cmd, String param) {
        cmd.accept(param);
    }

    public static void main(String[] args) {
        printString("str");
    }

    private static void printString(String string) {
        Map<String, Boolean> cache = new HashMap<>();

        StringCommandsExecutorLambdas lambdasExample = new StringCommandsExecutorLambdas();

        // #1
        lambdasExample.execute(System.out::println, string);

        // #2
        lambdasExample.execute(param -> cache.put(param, true), string);
    }


}
