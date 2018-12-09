package com.intive.trainings.java8.repeatable;

import java.lang.annotation.*;

public class RepeatableExample {

    @Repeatable(Can.List.class)
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.METHOD})
    @interface Can {
        String value() default "";

        @Retention(RetentionPolicy.SOURCE)
        @Target(ElementType.TYPE)
        @interface List {
            Can[] value();
        }
    }

    @Can("go to Plute and prove it's planet!")
    @Can("take you to the moon")
    @Can("look deep out of the solar system")
    @Can("just crash and fall into ocean")
    class Spaceship {}
}
