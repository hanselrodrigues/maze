package org.hansel.maze.controller;

import org.hansel.maze.model.Maze;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class MazeLoader {

    public Maze readFile(String fileName) throws FileNotFoundException {
        List<String> mazeDoubleArrayList = new ArrayList<>();
        Scanner sc = new Scanner(new File(fileName));
        sc.useDelimiter("\n");
        while (sc.hasNext()) {
            mazeDoubleArrayList.add(sc.next());
        }
        sc.close();
        return loadIntoMaze(mazeDoubleArrayList);
    }

    private Maze loadIntoMaze(List<String> mazeDoubleArrayList) {
        Maze maze = new Maze(mazeDoubleArrayList.size(), mazeDoubleArrayList.get(0).length());
        for (int row = 0; row < mazeDoubleArrayList.size(); row++) {
            String stringRow = mazeDoubleArrayList.get(row);
            for (int col = 0; col < stringRow.length(); col++) {
                String value = String.valueOf(stringRow.charAt(col));
                maze.setCell(row, col, value);
            }
        }
        return maze;
    }
}