package com.guitarhero.component;

import com.guitarhero.entity.Song;
import com.guitarhero.component.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.File;

public class LeftColumn {

    public LeftColumn() {

    }

<<<<<<< HEAD
=======
    /*public static void changeSong(Song song) {
        songName = song.getName();
        artist = song.getArtist();
        genre = song.getGenre().toString().replace("_", " ");
        genre = genre.replace(genre.charAt(0), Character.toUpperCase(genre.charAt(0)));
        highscore = song.getHighScore();
        path = song.getMidFile();
    }*/
>>>>>>> cce30755faec1fda05083ca60c3d151b3081ce4b

    public static void createLeftColumn(JPanel bar) {
        bar.setLayout(new BoxLayout(bar, BoxLayout.Y_AXIS));
        bar.setPreferredSize(new Dimension(500,800));
        bar.setAlignmentY(Component.TOP_ALIGNMENT);
        bar.setBackground(Color.GRAY);
        
        JLabel fields = new JLabel("Name        Artist       Genre");
        fields.setAlignmentX(Component.LEFT_ALIGNMENT);
        bar.add(fields);
        
        JPanel list = new JPanel();
        SongList.createSongList(list);
        bar.add(list);
        
        JPanel player = new JPanel();
        PlayComponent.createPlayComponent(player);
        bar.add(player);
        
        
     
    }



}
