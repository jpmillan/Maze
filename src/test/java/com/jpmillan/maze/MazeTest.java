package com.jpmillan.maze;

import com.jpmillan.maze.error.MazeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MazeTest {


    @Test
    @DisplayName("Test valid maze")
    public void constructorTest(){
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
        Maze maze = new Maze(standardMazeStr);

        assertNotNull( maze);

    }

    @Test
    @DisplayName("Test blank maze")
    public void invalidConstructorTest(){
        StringBuilder sb = new StringBuilder();

        String standardMazeStr = sb.toString();

        MazeException thrown = assertThrows(MazeException.class, () -> new Maze(standardMazeStr));
        assertEquals("Invalid maze:Input String is empty", thrown.getMessage());

    }

    @Test
    @DisplayName("Test null maze")
    public void nullConstructorTest(){

        MazeException thrown = assertThrows(MazeException.class, () -> new Maze(null));
        assertEquals("Invalid maze:Input String is empty", thrown.getMessage());

    }

}