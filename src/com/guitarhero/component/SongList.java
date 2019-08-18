package com.guitarhero.component;

import com.guitarhero.SongButtonListener;
import com.guitarhero.entity.Song;
import com.guitarhero.component.PlayComponent;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class SongList {

    public static Map<String, Song> songMap = new HashMap<>();
    private static Song selected;

    public SongList() {

    }
    
    public static void initializeSongs() {
        File file = new File("resources/songs/Ransom.mid");
        Song song = Song.constructSong("Ransom", "Lil Tecca", Song.Genre.HIP_HOP, file, "resources/songs/Ransom.jpg");
        songMap.put("Ransom", song);
    }

    public static void createSongList(JPanel list) {
    	list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS));
    	list.setAlignmentX(Component.CENTER_ALIGNMENT);
        list.setPreferredSize(new Dimension(300,600));
        list.setBorder(new EmptyBorder(20,20,20,20));
        list.setBackground(Color.GRAY);
        JButton test = new JButton("Title, Artist, Genre");
        test.setActionCommand("Ransom");
        test.addActionListener(new SongButtonListener());
        list.add(test);
        
        //Add jlist here
        
        //lscroller = new JScrollPane(list);
        //lscroller.setPreferredSize(new Dimension(300,300));
        //lscroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
    }



}
