package com.guitarhero.component;

import com.guitarhero.entity.Song;
import com.guitarhero.component.PlayComponent;
import java.util.Queue;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class GamePanel extends JPanel {
	
	
	private Image bg = new ImageIcon("resources/game_bg.png").getImage();

	public GamePanel() throws IOException {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(700,800));
        setBackground(new Color(11,11,15));
        //JLabel imageLabel = new JLabel(new ImageIcon("resources/game_bg.png"));
        //add(imageLabel);
	}

   
    public static void createGamePanel(JPanel game) {
    	game.setLayout(new BoxLayout(game, BoxLayout.Y_AXIS));
        game.setPreferredSize(new Dimension(700,800));
        game.setBackground(new Color(11,11,15));
        JLabel imageLabel = new JLabel(new ImageIcon("resources/game_bg.png"));
        game.add(imageLabel);
 
    }
    
    public static void drawnote(int note, Graphics g) {
    	switch(note){
    		case 1: 
    			g.setColor(Color.GREEN);
    		break;
    		case 2:
    			g.setColor(Color.RED);
    		break;
    		case 3:
    			g.setColor(Color.yellow);
    		break;
    		case 4:
    			g.setColor(Color.BLUE);
    		break;
    		case 5:
    			g.setColor(Color.ORANGE);
    		break;
    	}
    	
    	g.fillOval(128 + 65*note, 0, 50, 50);
    	g.setColor(Color.WHITE);
    	g.fillOval(140 + 65*note, 12, 25, 25);
    }
    
    public static void GameLoop(Song song) {
    	//While loop that updates note locations
    }
    
    @Override
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	g.drawImage(bg, 0,0,null);
    	drawnote(1,g);
    	drawnote(2,g);
    	drawnote(3,g);
    }
    



}
