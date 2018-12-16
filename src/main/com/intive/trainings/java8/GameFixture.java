package com.intive.trainings.java8;

import com.intive.trainings.java8.Game;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class GameFixture {

    public static List<Game> games() {
        return IntStream.range(0, 10)
                .mapToObj(i -> new Game("game" + i, LocalDate.now().minusMonths(i), new Random(1000L).nextInt()))
                .collect(toList());
    }

}
