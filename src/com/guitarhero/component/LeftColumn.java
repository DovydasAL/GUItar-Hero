package com.guitarhero.component;

import com.guitarhero.entity.Song;
import com.guitarhero.component.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class LeftColumn {

    public LeftColumn() {

    }


    public static void createLeftColumn(JPanel bar) throws IOException, Exception {
        bar.setLayout(new BoxLayout(bar, BoxLayout.Y_AXIS));
        bar.setPreferredSize(new Dimension(500,800));
        bar.setAlignmentY(Component.TOP_ALIGNMENT);
        bar.setBackground(new Color(69,10,12));
        
        JLabel title = new JLabel(new ImageIcon("resources/title.png"));
        bar.add(title);
        
        
        JLabel vineimg = new JLabel(new ImageIcon("resources/vine.png"));
        vineimg.setBackground(null);
        bar.add(vineimg);
        
        
        JLabel fields = new JLabel("Name                   Artist");
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
