package com.guitarhero.component;

import com.guitarhero.entity.Song;
import com.guitarhero.component.PlayComponent;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.io.File;

public class GamePanel {

	

    public GamePanel() {

    }
    
    

    public static void createGamePanel(JPanel game) {
    	game.setLayout(new BoxLayout(game, BoxLayout.Y_AXIS));
        game.setPreferredSize(new Dimension(700,800));
        game.setBackground(new Color(11,11,15));
        JLabel imageLabel = new JLabel(new ImageIcon("resources/game_bg.png"));
        game.add(imageLabel);
        
        

        
    }



}
