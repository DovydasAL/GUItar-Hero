package com.guitarhero.component;

import com.guitarhero.listener.SongButtonListener;
import com.guitarhero.entity.Song;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SongList {

    public static Map<String, Song> songMap = new HashMap<>();
    private static Song selected;

    public SongList() {

    }
    
    public static void initializeSongs() {
        File file = new File("resources/songs/Ransom.mid");
        Song song = Song.constructSong("Ransom", "Lil Tecca", Song.Genre.HIP_HOP, "resources/songs/Ransom.jpg", file, "resources/songs/Ransom.wav");
        songMap.put("Ransom", song);
    }

    public static void createSongList(JPanel list) {
    	list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS));
    	list.setAlignmentX(Component.LEFT_ALIGNMENT);
        list.setPreferredSize(new Dimension(300,600));
        list.setBorder(new EmptyBorder(20,20,20,20));
        list.setBackground(Color.GRAY);
        Set<String> stringSet = songMap.keySet();
        Iterator it = stringSet.iterator();
        while (it.hasNext()) {
            String songName = (String) it.next();
            Song song = songMap.get(songName);
            JButton button = new JButton(song.getName() + "  -  " + song.getArtist());
            button.setFont(button.getFont().deriveFont(18.0f));
            button.addActionListener(new SongButtonListener());
            button.setActionCommand(songName);
            list.add(button);
        }
        
        //Add jlist here
        
        //lscroller = new JScrollPane(list);
        //lscroller.setPreferredSize(new Dimension(300,300));
        //lscroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
    }



}
