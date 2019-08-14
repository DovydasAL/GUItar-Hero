package com.guitarhero;

import com.guitarhero.entity.Song;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Main {

    private static final Dimension dimensions = new Dimension(1400,800);

    public static void createComponents(JPanel screen) {

    }

    public static void main(String[] args) {
        //Make frame non-resizable
        JFrame frame = new JFrame();
        frame.setResizable(false);
        Container container = frame.getContentPane();
        JPanel mainScreen = new JPanel();
        //Set preferred dimensions
        mainScreen.setPreferredSize(dimensions);
        //Call function to add components to the screen
        createComponents(mainScreen);
        //Add screen to frame and make it visible
        container.add(mainScreen);
        frame.pack();
        frame.setVisible(true);

        File file = new File("../eof/Lil Tecca - Ransom/notes.mid");
	    Song song = Song.constructSong("Ransom", "Lil Tecca", file);
	    System.out.println("Test");
    }
}
