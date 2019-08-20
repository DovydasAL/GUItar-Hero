package com.guitarhero.entity;

import com.guitarhero.Main;
import com.guitarhero.component.GamePanel;

import java.util.concurrent.TimeUnit;

import static com.guitarhero.Main.gamePanel;

public class UpdateNotesThread implements Runnable {

    public static int millisecondsElapsed = 0;

    public void setGamePanel() {

    }

    public void run() {
        millisecondsElapsed = 0;
        while (true) {
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
