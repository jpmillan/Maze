package com.jpmillan.maze.error;

public class MazeException extends RuntimeException{
    public MazeException(String msg){
        super("Invalid maze:" + msg);
    }
}
