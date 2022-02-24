package org.hansel.maze.controller;

import org.hansel.maze.model.Maze;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;

@Component
public class MazeSolver {

    private static final String asterisk = "*";
    private static final String open = " ";
    private String[][] mazeData;

    public void solve(String mazeFile) throws FileNotFoundException {
        Maze maze = new MazeLoader().readFile(mazeFile);
        mazeData = maze.getData();

        if (solve(maze.getStartingPoint().getX(), maze.getStartingPoint().getY(), maze)) {
            maze.print();
        } else {
            System.out.println("Sorry! You're stuck in the tomb!");
        }
    }

    public boolean solve(int column, int row, Maze maze) {
        // Make the move (if it's wrong, we will backtrack later).
        maze.setCell(row, column, asterisk);

        // Check if we have reached our goal.
        if (column == maze.getEndingPoint().getX() && row == maze.getEndingPoint().getY()) {
            return true;
        }

        // Recursively search for our goal.
        if (column > 0 && mazeData[row][column - 1].equals(open) && solve(column - 1, row, maze)) {
            return true;
        }
        if (column < maze.getColumns() && mazeData[row][column + 1].equals(open) && solve(column + 1, row, maze)) {
            return true;
        }
        if (row > 0 && mazeData[row - 1][column].equals(open) && solve(column, row - 1, maze)) {
            return true;
        }
        if (row < maze.getRows() && mazeData[row + 1][column].equals(open) && solve(column, row + 1, maze)) {
            return true;
        }

        // Otherwise, we need to backtrack and find another solution.
        mazeData[row][column] = open;
        return false;
    }
}