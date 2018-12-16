package com.intive.trainings.java8.streams;

import com.intive.trainings.java8.Game;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static com.intive.trainings.java8.GameFixture.games;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class OldJavaVsJava8Example {

    /*
     * EXERCISE: get up to 2 game names, for games not older than 5 months
     */

    List<String> doingQueryInOldStyle() {
        List<Game> games = games();
        games.sort(new Comparator<Game>() {
            @Override
            public int compare(Game game, Game otherGame) {
                return game.getFirstRun().compareTo(otherGame.getFirstRun());
            }
        });
        List<Game> result = games.subList(0, 2);
        List<String> gameNames = new ArrayList<>();
        for (Game g : result) {
            gameNames.add(g.getName());
        }
        return gameNames;
    }

    List<String> doingQueryInJava8Style() {
        return games().stream()
                .sorted(comparing(Game::getFirstRun))
                .limit(2)
                .map(Game::getName)
                .collect(toList());
    }

    public static void main(String[] args) {
        OldJavaVsJava8Example exampler = new OldJavaVsJava8Example();
        List<String> gamesByOldStyle = exampler.doingQueryInOldStyle();
        List<String> gamesByJava8 = exampler.doingQueryInJava8Style();

        System.out.println(gamesByJava8);
        System.out.println(gamesByOldStyle);

        assert gamesByJava8.equals(gamesByOldStyle) : "Game lists should be equal!";
    }
}
