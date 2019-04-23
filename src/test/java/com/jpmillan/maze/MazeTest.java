package com.jpmillan.maze;

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
    @DisplayName("Test invalid maze")
    public void invalidConstructorTest(){
        StringBuilder sb = new StringBuilder();
        sb.append("");

        String standardMazeStr = sb.toString();

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> new Maze(standardMazeStr));
        assertEquals("Invalid Maze String", thrown.getMessage());

    }

    @Test
    @DisplayName("Test null maze")
    public void nullConstructorTest(){

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> new Maze(null));
        assertEquals("Invalid Maze String", thrown.getMessage());

    }

}