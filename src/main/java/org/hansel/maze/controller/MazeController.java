package org.hansel.maze.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MazeController {

    @Autowired
    private MazeSolver mazeSolver;

    @PostMapping("/maze")
    public String solveMaze(@RequestBody String maze) {
        return mazeSolver.solve(maze);
    }
}