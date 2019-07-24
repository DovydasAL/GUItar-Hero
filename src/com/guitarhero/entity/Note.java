package com.guitarhero.entity;

public class Note {
    private boolean green, red, yellow, blue, orange;
    private int timestamp;
    private Note nextNote;

    public Note(boolean green, boolean red, boolean yellow,
                boolean blue, boolean orange, int timestamp) {
        this.green = green;
        this.red = red;
        this.yellow = yellow;
        this.blue = blue;
        this.orange = orange;
    }

    public void setNextNote(Note nextNote) {
        this.nextNote = nextNote;
    }

    public Note getNextNote() {
        return nextNote;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public boolean isRed() {
        return red;
    }

    public boolean isGreen() {
        return green;
    }
    public boolean isYellow() {
        return yellow;
    }
    public boolean isBlue() {
        return blue;
    }
    public boolean isOrange() {
        return orange;
    }

}
