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
