package com.guitarhero;

import com.guitarhero.component.PlayComponent;
import com.guitarhero.component.SongList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SongButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
        String songName = event.getActionCommand();
        PlayComponent.changeSong(SongList.songMap.get(songName));
    }
}