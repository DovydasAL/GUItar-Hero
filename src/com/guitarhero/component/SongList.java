package com.guitarhero.component;

import com.guitarhero.entity.Song;
import com.guitarhero.component.PlayComponent;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.io.File;

public class SongList {

    private static Song[] list;
    private static Song selected;

    public SongList() {

    }
    
    

    public static void createSongList(JPanel list) {
    	list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS));
    	list.setAlignmentX(Component.LEFT_ALIGNMENT);
        list.setPreferredSize(new Dimension(300,600));
        list.setBorder(new EmptyBorder(20,20,20,20));
        list.setBackground(Color.GRAY);
        JButton test = new JButton("Title, Artist, Genre");
        list.add(test);
        
        //lscroller = new JScrollPane(list);
        //lscroller.setPreferredSize(new Dimension(300,300));
        //lscroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
    }



}
