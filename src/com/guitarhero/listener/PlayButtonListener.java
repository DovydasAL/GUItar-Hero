package com.guitarhero.listener;

import com.guitarhero.component.PlayComponent;
import com.guitarhero.component.SongList;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayButtonListener implements ActionListener {

    public static boolean playing = false;

    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().equals("togglePlay")) {
            if (playing) {
                playing = false;
                for (JButton button : SongList.buttons) {
                    button.setEnabled(true);
                }
                PlayComponent.play.setText("Play");

            } else {
                playing = true;
                for (JButton button : SongList.buttons) {
                    button.setEnabled(false);
                }
                PlayComponent.play.setText("Stop");
            }
        }
    }
}
