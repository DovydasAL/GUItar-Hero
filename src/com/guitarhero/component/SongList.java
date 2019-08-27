package com.guitarhero.component;

import com.guitarhero.listener.SongButtonListener;
import com.guitarhero.entity.Song;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystem;
import java.util.*;

public class SongList {

    public static Map<String, Song> songMap = new HashMap<>();
    public static ArrayList<JButton> buttons = new ArrayList<>();
    public static Song selected;

    public SongList() {
    	
    }
    
    public static void initializeSongs() {
        File file = new File("resources/songs/Ransom.mid");
        Song song = Song.constructSong("Ransom", "Lil Tecca", Song.Genre.HIP_HOP, "resources/songs/Ransom.jpg", file, "resources/songs/Ransom.wav");
        songMap.put("Ransom", song);
    }

    public static void createSongList(JPanel list) throws FontFormatException, IOException {
    	list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS));
    	list.setAlignmentX(Component.LEFT_ALIGNMENT);
        list.setPreferredSize(new Dimension(500,500));
        list.setBorder(new EmptyBorder(20,20,20,20));
        list.setBackground(null);
        Set<String> stringSet = songMap.keySet();
        Iterator it = stringSet.iterator();
        
      //create the font to use. Specify the size!
        Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("resources/fonts/Roddenberry Italic.ttf"));
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        //register the font
        ge.registerFont(customFont);
        
        while (it.hasNext()) {
            String songName = (String) it.next();
            Song song = songMap.get(songName);
            JButton button = new JButton(song.getName() + "  |  " + song.getArtist());
            button.setFont(customFont.deriveFont(26.0f));
            button.addActionListener(new SongButtonListener());
            button.setBorderPainted(false);
            button.setFocusPainted(false);
            button.setBackground(new Color(30,5,6));
            button.setForeground(Color.WHITE);
            button.setActionCommand(songName);
            buttons.add(button);
            list.add(button);
        }
        
        //Add jlist here
        
    }



}
