package com.jpmillan.maze;

public class Step {

    int x,y;

    Step prevStep;


    public Step(int x, int y){
        this.x = x;
        this.y = y;
        this.prevStep = null;
    }

    public Step(int x, int y, Step prevStep){
        this.x = x;
        this.y = y;
        this.prevStep = prevStep;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Step getPrevStep() {
        return prevStep;
    }
}
