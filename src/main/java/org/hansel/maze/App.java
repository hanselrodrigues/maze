package org.hansel.maze;

import org.hansel.maze.controller.MazeSolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;

/**
 * King Tut's Tomb!
 */

@SpringBootApplication
public class App {

    public static void main(String[] args) throws FileNotFoundException {
        SpringApplication.run(App.class, args);
        System.out.println("Welcome to King Tut's Tomb!  Follow the path of the asterisks (*) to find your way out!");
        new MazeSolver().solve(args[0]);
    }
}