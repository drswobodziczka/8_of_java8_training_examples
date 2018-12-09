package com.intive.trainings.java8.repeatable;

public class WhenIWantedToRepeatBeforeJava8Example {

    private @interface CanContainer {
        Can[] value();
    }

    private @interface Can {
        String value();
    }
    /**
     * Pitfalls:
     * - client code less readable
     * - annotation processing more complex
     * TODO: show annotation processing is harder
     * */
    @CanContainer({
            @Can("go to Pluto and finally prove it's planet!"),
            @Can("take you to the moon"),
            @Can("look deep out of the solar system"),
            @Can("just crash and fall into ocean")})
    private class Spaceship {}
}
