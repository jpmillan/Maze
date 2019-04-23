package com.jpmillan.maze;

import com.jpmillan.maze.error.MazeException;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class Maze {

    private String mazeStr;
    private int[][] mazeArray;



    private static final int ROAD = 0;
    private static final int WALL = 1;
    private static final int START = 2;
    private static final int FINISH = 3;
    private static final int PATH = 4;


    private boolean[][] visited;
    private Step start, end;

    public Maze(String mazeStr){
        this.mazeStr = mazeStr;
        initMaze();
    }

    private void initMaze(){

        validateMaze();

        String[] lines = mazeStr.split("[\r]?\n");
        mazeArray = new int[lines.length][lines[0].length()];
        visited = new boolean[lines.length][lines[0].length()];
        for (int row = 0; row < getHeight(); row++) {
            if (lines[row].length() != getWidth()) {
                throw new MazeException("Line "+(row + 1)+" invalid length:"+lines[row].length());
            }
            for (int col = 0; col < getWidth(); col++) {
                if (lines[row].charAt(col) == '#') {
                    mazeArray[row][col] = WALL;
                }else if (lines[row].charAt(col) == 'S') {
                    mazeArray[row][col] = START;
                    start = new Step(row, col);
                } else if (lines[row].charAt(col) == 'F') {
                    mazeArray[row][col] = FINISH;
                    end = new Step(row, col);
                } else
                    mazeArray[row][col] = ROAD;
            }
        }
    }


    private void validateMaze(){
        if (StringUtils.isEmpty(mazeStr)) {
            throw new MazeException("Input String is empty");
        }else if (!StringUtils.contains(mazeStr, "F")) {
            throw new MazeException("Finish line is mandatory");
        }else if (!StringUtils.contains(mazeStr, "S")) {
            throw new MazeException("Starting position is mandatory");
        }else if (!StringUtils.contains(mazeStr, "#")) {
            throw new MazeException("Maze walls are mandatory");
        }
    }

    public int getHeight() {
        return mazeArray.length;
    }

    public int getWidth() {
        return mazeArray[0].length;
    }

    public Step getEntry() {
        return start;
    }

    public boolean isExit(int x, int y) {
        return x == end.getX() && y == end.getY();
    }

    public boolean isStart(int x, int y) {
        return x == start.getX() && y == start.getY();
    }

    public boolean isExplored(int row, int col) {
        return visited[row][col];
    }

    public boolean isWall(int row, int col) {
        return mazeArray[row][col] == WALL;
    }

    public void setVisited(int row, int col, boolean value) {
        visited[row][col] = value;
    }

    public boolean isValidLocation(int row, int col) {
        if (row < 0 || row >= getHeight() || col < 0 || col >= getWidth()) {
            return false;
        }
        return true;
    }

    public String getFinalSolution(List<Step> path) {
        int[][] tempMaze = Arrays.stream(mazeArray)
                .map(int[]::clone)
                .toArray(int[][]::new);

        path.forEach(e -> {
            if (isStart(e.getX(), e.getY())
                    || isExit(e.getX(), e.getY())) {
            }else{
                tempMaze[e.getX()][e.getY()] = PATH;
            }
        });

       return toString(tempMaze);
    }

    public String toString(int[][] maze) {
        StringBuilder result = new StringBuilder(getWidth() * (getHeight() + 1));
        for (int row = 0; row < getHeight(); row++) {
            for (int col = 0; col < getWidth(); col++) {
                if (maze[row][col] == ROAD) {
                    result.append(' ');
                } else if (maze[row][col] == WALL) {
                    result.append('#');
                } else if (maze[row][col] == START) {
                    result.append('S');
                } else if (maze[row][col] == FINISH) {
                    result.append('F');
                } else {
                    result.append('.');
                }
            }
            result.append('\n');
        }
        return result.toString();
    }
}
