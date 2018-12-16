package com.intive.trainings.java8.lambdas;

import com.intive.trainings.java8.Game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;
import java.util.Comparator;
import java.util.List;

import static com.intive.trainings.java8.GameFixture.games;
import static java.util.Comparator.comparing;

public class HowToImproveLegacyCodeWithLambdasExample {

    public static void main(String[] args) {

        // #1 swing components action listeners
        JButton jButton = new JButton();
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getActionCommand());
            }
        });

        jButton.addActionListener(e -> System.out.println(e.getActionCommand()));

        // #2 programming with threads
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                // do something
            }
        });

        thread = new Thread(() -> { /* do something */ });

        // #3 sort games by the rank with custom comparator
        List<Game> games = games();
        games.sort(new Comparator<Game>() {
            @Override
            public int compare(Game first, Game second) {
                return first.getRank().compareTo(second.getRank());
            }
        });

        // #3.1 lambdas..
        List<Game> games1 = games();
        games1.sort((first, second) -> first.getRank().compareTo(second.getRank()));

        // #3.2 comparing from Comparator
        List<Game> games2 = games();
        games2.sort(comparing(Game::getRank));

        // #4 filtering files
        File[] files = new File("").listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return false;
            }
        });

        File[] filesWithLambda = new File("").listFiles(pathname -> false);

        // #5
    }
}
