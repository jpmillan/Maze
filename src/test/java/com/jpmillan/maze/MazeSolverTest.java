package com.jpmillan.maze;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MazeSolverTest {

    Maze maze;

    @BeforeEach
    public void init(){
        StringBuilder sb = new StringBuilder();
        sb.append("###########\n");
        sb.append("S #   #   #\n");
        sb.append("# # # # # #\n");
        sb.append("#   #   # #\n");
        sb.append("######### #\n");
        sb.append("# #       #\n");
        sb.append("# # #######\n");
        sb.append("# #   #   #\n");
        sb.append("# # # ### #\n");
        sb.append("#   #     F\n");
        sb.append("###########\n");

        String standardMazeStr = sb.toString();

        maze = new Maze(standardMazeStr);
    }

    @Test
    @DisplayName("Test sample maze solution")
    public void solveMaze() {

        MazeSolver mazeSolver = new MazeSolver();

        StringBuilder sb2 = new StringBuilder();
        sb2.append("###########\n");
        sb2.append("S.#...#...#\n");
        sb2.append("#.#.#.#.#.#\n");
        sb2.append("#...#...#.#\n");
        sb2.append("#########.#\n");
        sb2.append("# #.......#\n");
        sb2.append("# #.#######\n");
        sb2.append("# #...#   #\n");
        sb2.append("# # #.### #\n");
        sb2.append("#   #.....F\n");
        sb2.append("###########\n");

        String expectedSolution = sb2.toString();
        assertEquals(expectedSolution, mazeSolver.solveMaze(maze));



    }


}