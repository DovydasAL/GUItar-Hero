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

    /*public static void changeSong(Song song) {
        songName = song.getName();
        artist = song.getArtist();
        genre = song.getGenre().toString().replace("_", " ");
        genre = genre.replace(genre.charAt(0), Character.toUpperCase(genre.charAt(0)));
        highscore = song.getHighScore();
        path = song.getFile();
    }*/

    public static void createLeftColumn(JPanel bar) {
        bar.setLayout(new BorderLayout());
        bar.setPreferredSize(new Dimension(500,650));
        bar.setBackground(Color.GRAY);
        
        JLabel fields = new JLabel("Name        Artist       Genre");
        bar.add(fields, BorderLayout.NORTH);
        
        JPanel list = new JPanel();
        SongList.createSongList(list);
        bar.add(list, BorderLayout.CENTER);
        
        JPanel player = new JPanel();
        PlayComponent.createPlayComponent(player);
        bar.add(player, BorderLayout.SOUTH);
        
        
        
        

        /*Font font = songNameLabel.getFont().deriveFont(18.0f);
        songNameLabel.setFont(font);
        artistLabel.setFont(font);
        genreLabel.setFont(font);
        highScoreLabel.setFont(font);*/
        
    }



}
