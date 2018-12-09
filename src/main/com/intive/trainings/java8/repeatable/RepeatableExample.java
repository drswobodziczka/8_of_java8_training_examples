package com.intive.trainings.java8.repeatable;

import java.lang.annotation.Repeatable;

public class RepeatableExample {

    @Repeatable(Can.List.class)
    private @interface Can {
        String value() default "";

        @interface List {
            Can[] value();
        }
    }

    @Can("go to Pluto and finally prove it's planet!")
    @Can("take you to the moon")
    @Can("look deep out of the solar system")
    @Can("just crash and fall into ocean")
    private class Spaceship {}
}
