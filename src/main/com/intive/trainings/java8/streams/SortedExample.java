package com.intive.trainings.java8.streams;

import com.intive.trainings.java8.Game;

import java.util.Comparator;
import java.util.List;

import static com.intive.trainings.java8.GameFixture.games;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class SortedExample {

    private List<Game> doItInOldStyle() {
        List<Game> games = games();
        games.sort(new Comparator<Game>() {
            @Override
            public int compare(Game game, Game otherGame) {
                return game.getFirstRun().compareTo(otherGame.getFirstRun());
            }
        });
        return games;
    }

    /*
    *
    * */
    private List<Game> doItInHalfOldStyle() {
        List<Game> games = games();
        games.sort(comparing(Game::getFirstRun));
        return games;
    }

    private List<Game> doItInJava8Style() {
        return games().stream()
                .sorted(comparing(Game::getFirstRun))
                .collect(toList());
    }

    public static void main(String[] args) {
        SortedExample example = new SortedExample();

        List<Game> gamesByOld = example.doItInOldStyle();
        List<Game> gamesByJava8 = example.doItInJava8Style();

        assert gamesByJava8.equals(gamesByOld);
    }
}
