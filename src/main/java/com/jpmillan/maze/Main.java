package com.jpmillan.maze;

public class Main {

    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer();
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

        Maze maze = new Maze(sb.toString());
        MazeSolver ms = new MazeSolver();
        ms.solveMaze(maze);

        sb = new StringBuffer();
        sb.append("###########\n");
        sb.append("S #   #   F\n");
        sb.append("#   #   # #\n");
        sb.append("# # #   # #\n");
        sb.append("###########\n");


        maze = new Maze(sb.toString());

        ms = new MazeSolver();
        ms.solveMaze(maze);

    }
}
