package org.hansel.maze.model;

import lombok.Getter;

@Getter
public class Maze {
    private final int rows;
    private final int columns;
    private final Coordinate startingPoint = new Coordinate();
    private final Coordinate endingPoint = new Coordinate();
    private final String[][] data;

    public Maze(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.data = new String[rows][columns];
    }

    public void setCell(int row, int column, String value) {
        data[row][column] = value;
        if (value.equals("S")) {
            startingPoint.setX(column);
            startingPoint.setY(row);
            data[row][column] = " ";
        }
        if (value.equals("E")) {
            endingPoint.setX(column);
            endingPoint.setY(row);
            data[row][column] = " ";
        }
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                sb.append(data[row][col]);
            }
            sb.append(System.getProperty("line.separator"));
        }
        return sb.toString();
    }
}