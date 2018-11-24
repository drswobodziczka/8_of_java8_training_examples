package com.intive.trainings.java8.lambdas;

import java.util.HashMap;
import java.util.Map;

public class StringCommandsExecutor {

    private void doSomething(StringCommand cmd, String param) {
        cmd.accept(param);
    }

    interface StringCommand {
        void accept(String param);
    }

    public static void main(String[] args) {
        Map<String, Boolean> cache = new HashMap<>();

        StringCommandsExecutor lambdasExample = new StringCommandsExecutor();

        lambdasExample.doSomething(new StringCommand() {
            @Override
            public void accept(String param) {
                System.out.println(param);
            }
        }, "string");

        lambdasExample.doSomething(new StringCommand() {
            @Override
            public void accept(String param) {
                cache.put(param, true);
            }
        }, "string");
    }
}
