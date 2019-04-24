package com.jpmillan.maze;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        if(args.length > 0){

            String fileName = args[0];
            Main thisClass = new Main();

            try {
                Path path = Paths.get(thisClass.getClass().getClassLoader()
                        .getResource(fileName).toURI());

                Stream<String> lines = Files.lines(path);
                String mazeStr = lines.collect(Collectors.joining("\n"));
                lines.close();

                Maze maze = new Maze(mazeStr);
                MazeSolver ms = new MazeSolver();
                ms.solveMaze(maze);

            } catch (URISyntaxException | IOException e) {
                e.printStackTrace();
            }


        } else {

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
}
