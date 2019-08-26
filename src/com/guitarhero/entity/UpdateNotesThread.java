package com.guitarhero.entity;

import com.guitarhero.Main;
import com.guitarhero.component.GamePanel;

import java.util.concurrent.TimeUnit;

import static com.guitarhero.Main.gamePanel;

public class UpdateNotesThread implements Runnable {

    public int millisecondsElapsed = 0;
    public static boolean stop = false;

    public void setGamePanel() {
        millisecondsElapsed = 0;
        stop = false;
    }

    public void run() {
        millisecondsElapsed = 0;
        while (!stop) {
            try {
                Main.gamePanel.checkForNote(millisecondsElapsed);
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                System.out.println("Interrupted in checkForNote");
            }
            millisecondsElapsed = millisecondsElapsed + 50;
        }
    }

}
