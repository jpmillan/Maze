package com.jpmillan.maze;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MazeSolverTest {

    Maze maze;

    @BeforeEach
    public void init(){

    }

    @Test
    @DisplayName("Test sample maze solution")
    public void solveMaze() {

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
        mazeSolver.solveMaze(maze);
        assertEquals(expectedSolution, mazeSolver.getSolution());

    }

    @Test
    @DisplayName("Test simple maze")
    public void solveSimpleMaze() {

        StringBuilder sb = new StringBuilder();
        sb.append("###########\n");
        sb.append("S         F\n");
        sb.append("###########\n");

        maze = new Maze(sb.toString());
        MazeSolver mazeSolver = new MazeSolver();
        mazeSolver.solveMaze(maze);

        StringBuilder sb2 = new StringBuilder();
        sb2.append("###########\n");
        sb2.append("S.........F\n");
        sb2.append("###########\n");


        assertEquals(sb2.toString(), mazeSolver.getSolution());
        //MazeException thrown = assertThrows(MazeException.class, () -> );



    }

    @Test
    @DisplayName("Test unsolveable maze")
    public void solveInvalidMaze() {

        StringBuilder sb = new StringBuilder();
        sb.append("###########\n");
        sb.append("S #   #   #\n");
        sb.append("# # # # # #\n");
        sb.append("#   #   ###\n");
        sb.append("#########F#\n");

        maze = new Maze(sb.toString());

        MazeSolver mazeSolver = new MazeSolver();
        mazeSolver.solveMaze(maze);
        assertEquals("unsolvable maze", mazeSolver.getSolution());
        //MazeException thrown = assertThrows(MazeException.class, () -> );



    }


}