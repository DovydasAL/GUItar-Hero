package com.guitarhero.entity;

public class GraphicNote {

    public int yOffset;
    public int xPosition;
    public boolean gray;
    public String color;

    public GraphicNote(int xPosition, String color) {
        this.yOffset = 0;
        this.xPosition = xPosition;
        this.color = color;
    }

    public void setGray() {
        this.gray = true;
    }

}
