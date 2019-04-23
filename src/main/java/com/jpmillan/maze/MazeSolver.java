package com.jpmillan.maze;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MazeSolver {

    private String solution;
    private static final String UNSOLVABLE = "unsolvable maze";
    public String getSolution() {
        return solution;
    }

    public void solveMaze(Maze maze){

        LinkedList<Step> nextToVisit = new LinkedList<>();
        Step start = maze.getEntry();
        nextToVisit.add(start);

        while (!nextToVisit.isEmpty()) {
            Step cursor = nextToVisit.remove();

            if (!maze.isValidLocation(cursor.getX(), cursor.getY()) || maze.isExplored(cursor.getX(), cursor.getY())) {
                continue;
            }else if (maze.isWall(cursor.getX(), cursor.getY())) {
                maze.setVisited(cursor.getX(), cursor.getY(), true);//handle wall bumps
                continue;
            }else if (maze.isExit(cursor.getX(), cursor.getY())) {
                this.solution = maze.getFinalSolution(getStepPath(cursor));//end maze if finish line is found
                System.out.println(solution);
                break;
            }
            int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
            for (int[] dir : directions) {
                Step coordinate = new Step(cursor.getX() + dir[0], cursor.getY() + dir[1], cursor);
                nextToVisit.add(coordinate);
                maze.setVisited(cursor.getX(), cursor.getY(), true);
            }
        }
        if(StringUtils.isEmpty(solution)) {
            this.solution = UNSOLVABLE;
        }
    }

    private List<Step> getStepPath(Step cur) {
        List<Step> path = new ArrayList<>();
        Step iter = cur;
        while (iter != null) {
            path.add(iter);
            iter = iter.prevStep;
        }
        return path;
    }

}
