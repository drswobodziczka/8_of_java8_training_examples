package com.intive.trainings.java8.lambdas;

import java.util.HashMap;
import java.util.Map;

public class StringCommandsExecutor {

    interface StringCommand {
        void accept(String param);
    }

    private void execute(StringCommand cmd, String param) {
        cmd.accept(param);
    }

    public static void main(String[] args) {
        Map<String, Boolean> cache = new HashMap<>();

        StringCommandsExecutor commandExecutor = new StringCommandsExecutor();

        commandExecutor.execute(new StringCommand() {
            @Override
            public void accept(String param) {
                System.out.println(param);
            }
        }, "string");

        commandExecutor.execute(new StringCommand() {
            @Override
            public void accept(String param) {
                cache.put(param, true);
            }
        }, "string");
    }
}
