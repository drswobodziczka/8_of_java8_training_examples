package com.intive.trainings.java8.streams;

import com.intive.trainings.java8.streams.helper.Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.intive.trainings.java8.streams.helper.GameFixture.games;

public class ReduceExample {

    private String joinItInOldStyle() {
        List<Game> games = games();
        StringBuilder result = new StringBuilder();
        for (Game game : games) {
            result.append(game.getName());
        }
        return result.toString();
    }

    private String joinItInJava8Style() {
        List<Game> games = games();

        //
        String reduced = games.stream()
                .map(Game::getName)
                .reduce("", String::concat);

        //
        String joined = games.stream()
                .map(Game::getName)
                .collect(Collectors.joining());

        return reduced;
    }

    private int sumItInOldStyle() {
        int[] numbers = new int[] {1, 2, 3, 5, 6, 7, 8, 8, 10};
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    private int sumItInJava8Style() {
        //
        int reduced = Arrays.stream(new int[]{1, 2, 3, 5, 6, 7, 8, 8, 10})
                .reduce(0, (a, b) -> a + b);

        //
        int sum = Arrays.stream(new int[]{1, 2, 3, 5, 6, 7, 8, 8, 10}).sum();

        return sum;
    }

    private void anotherReduceOperationsInJava8() {
        //
        int max = Arrays.stream(new int[]{1, 2, 3, 5, 6, 7, 8, 8, 10})
                .max()
                .orElse(-1);

        System.out.println("max: " + max);

        //
        int min = Arrays.stream(new int[]{1, 2, 3, 5, 6, 7, 8, 8, 10})
                .min()
                .orElse(-1);

        System.out.println("min: " + min);

        //
        long count = Arrays.stream(new int[]{1, 2, 3, 5, 6, 7, 8, 8, 10})
                .count();

        System.out.println("count: " + count);
    }

    public static void main(String[] args) {
        ReduceExample example = new ReduceExample();
        System.out.println("join old: " + example.joinItInOldStyle());
        System.out.println("join new: " + example.joinItInJava8Style());
        System.out.println("sum old: " + example.sumItInOldStyle());
        System.out.println("sum new: " +  example.sumItInJava8Style());
        example.anotherReduceOperationsInJava8();
    }
}
