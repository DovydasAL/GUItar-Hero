package com.guitarhero;

import com.guitarhero.component.*;
import com.guitarhero.entity.Song;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Main {

    private static final Dimension dimensions = new Dimension(1400,800);
    private static JPanel mainScreen;
    private static GridBagConstraints c;



    public static void createComponents() {
        JPanel leftcol = new JPanel();
        LeftColumn.createLeftColumn(leftcol);
        //PlayComponent.createPlayComponent(playPanel);
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.NORTHWEST;
        c.weighty = 1;
        c.weightx = 1;
        mainScreen.add(leftcol,c);
    }

    public static void createMenuBar(JFrame frame) {
        JMenuBar menuBar = new JMenuBar();
        JMenu options = new JMenu("Options");
        JMenu help = new JMenu("Help");
        JMenu loadFile = new JMenu("Load Song");
        menuBar.add(options);
        menuBar.add(help);
        menuBar.add(loadFile);
        frame.setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        //Make frame non-resizable
        JFrame frame = new JFrame("GUItar Hero");
        frame.setResizable(false);
        Container container = frame.getContentPane();
        mainScreen = new JPanel();
        mainScreen.setLayout(new GridBagLayout());
        c = new GridBagConstraints();
        //Set preferred dimensions
        mainScreen.setPreferredSize(dimensions);
        createMenuBar(frame);
        //Call function to add components to the screen
        createComponents();
        //Add screen to frame and make it visible
        container.add(mainScreen);
        frame.pack();
        frame.setVisible(true);
        File file = new File("../eof/Lil Tecca - Ransom/notes.mid");
	    Song song = Song.constructSong("Ransom", "Lil Tecca", Song.Genre.HIP_HOP, file);
	    System.out.println("Test");
    }
}
