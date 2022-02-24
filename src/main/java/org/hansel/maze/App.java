package org.hansel.maze;

import org.hansel.maze.controller.MazeSolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.FileNotFoundException;

/**
 * King Tut's Tomb!
 */

@SpringBootApplication
@ComponentScan(basePackages = { "org.hansel.maze.*" })
public class App implements CommandLineRunner {

    @Autowired
    private MazeSolver mazeSolver;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws FileNotFoundException {
        System.out.println("Welcome to King Tut's Tomb!  Follow the path of the asterisks (*) to find your way out!");
        mazeSolver.solve(args[0]);
    }
}