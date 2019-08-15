package com.guitarhero;

import com.guitarhero.component.PlayComponent;
import com.guitarhero.entity.Song;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Main {

    private static final Dimension dimensions = new Dimension(1400,800);



    public static void createComponents(JPanel screen) {
        JPanel playPanel = new JPanel();
        PlayComponent.createPlayComponent(playPanel);
        screen.add(playPanel);
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
        JPanel mainScreen = new JPanel();
        //Set preferred dimensions
        mainScreen.setPreferredSize(dimensions);
        createMenuBar(frame);
        //Call function to add components to the screen
        createComponents(mainScreen);
        //Add screen to frame and make it visible
        container.add(mainScreen);
        frame.pack();
        frame.setVisible(true);
        File file = new File("../eof/Lil Tecca - Ransom/notes.mid");
	    Song song = Song.constructSong("Ransom", "Lil Tecca", Song.Genre.HIP_HOP, file);
	    System.out.println("Test");
    }
}
