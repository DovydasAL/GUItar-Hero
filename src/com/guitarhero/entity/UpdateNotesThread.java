package com.guitarhero.entity;

import com.guitarhero.Main;
import com.guitarhero.component.GamePanel;
import com.guitarhero.component.PlayComponent;

import java.util.concurrent.TimeUnit;

import static com.guitarhero.Main.gamePanel;

public class UpdateNotesThread implements Runnable {

    public static double millisecondsElapsed = 0;
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
                TimeUnit.MILLISECONDS.sleep(3);
            } catch (InterruptedException e) {
                System.out.println("Interrupted in checkForNote");
            }
            millisecondsElapsed = millisecondsElapsed + 3.4;
            if (millisecondsElapsed * (Math.pow(10, 3))  > PlayComponent.clip.getMicrosecondLength()) {
                Main.stopGame();
            }
        }
    }

}
