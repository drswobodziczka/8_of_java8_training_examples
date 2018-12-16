package com.intive.trainings.java8;

import java.time.LocalDate;
import java.util.Objects;

public class Game {
    private String name;
    private LocalDate firstRun;
    private Integer rank;

    Game(String name, LocalDate firstRun, int rank) {
        this.name = name;
        this.firstRun = firstRun;
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public LocalDate getFirstRun() {
        return firstRun;
    }

    public Integer getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", firstRun=" + firstRun +
                ", rank=" + rank +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return rank == game.rank &&
                Objects.equals(name, game.name) &&
                Objects.equals(firstRun, game.firstRun);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, firstRun, rank);
    }
}
