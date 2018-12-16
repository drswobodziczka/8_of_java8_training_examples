package com.intive.trainings.java8.streams;

import com.intive.trainings.java8.streams.helper.Game;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static com.intive.trainings.java8.streams.helper.GameFixture.games;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class FilterExample {

    private List<Game> doItInOldStyle() {
        List<Game> games = games();
        ArrayList<Game> filteredGames = new ArrayList<>();
        for (Game game : games) {
            if (game.getFirstRun().isBefore(LocalDate.parse("2018-09-09"))) {
                filteredGames.add(game);
            }
        }
        return filteredGames;
    }

    private List<Game> doItInJava8Style() {
        List<Game> games = games();
        return games.stream()
                .filter(game -> game.getFirstRun().isBefore(LocalDate.parse("2018-09-09")))
                .collect(toList());
    }

    public static void main(String[] args) {
        FilterExample example = new FilterExample();

        List<Game> gamesByOld = example.doItInOldStyle();
        List<Game> gamesByJava8 = example.doItInJava8Style();

        assert gamesByJava8.equals(gamesByOld);
    }
}
