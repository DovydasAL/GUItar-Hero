package com.guitarhero;

import com.guitarhero.entity.Song;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Main {

    private static final Dimension dimensions = new Dimension(1400,800);

    public static void createPlayComponent(JPanel screen) {
        screen.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.NONE;
        JLabel songName = new JLabel("Song: ", SwingConstants.LEFT);
        JLabel artist = new JLabel("Artist: ", SwingConstants.LEFT);
        JLabel genre = new JLabel("Genre: ", SwingConstants.LEFT);
        JLabel highScore = new JLabel("Highscore: ", SwingConstants.LEFT);
        JLabel image = new JLabel(new ImageIcon("resources/test.png"), SwingConstants.LEFT);

        Font font = songName.getFont().deriveFont(18.0f);
        songName.setFont(font);
        artist.setFont(font);
        genre.setFont(font);
        highScore.setFont(font);
        constraints.weightx = 0.3;
        constraints.weighty = 0.3;
        constraints.ipadx = 20;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 4;
        constraints.anchor = GridBagConstraints.EAST;
        screen.add(image, constraints);
        constraints.anchor = GridBagConstraints.WEST;
        constraints.gridheight = 1;
        constraints.gridx = 1;
        constraints.gridy = 0;
        screen.add(songName, constraints);
        constraints.gridy = 1;
        screen.add(artist, constraints);
        constraints.gridy = 2;
        screen.add(genre, constraints);
        constraints.gridy = 3;
        screen.add(highScore, constraints);
    }

    public static void createComponents(JPanel screen) {
        JPanel playPanel = new JPanel();
        createPlayComponent(playPanel);
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
