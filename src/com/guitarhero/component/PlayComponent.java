package com.guitarhero.component;

import com.guitarhero.entity.Song;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.File;

public class PlayComponent {

    private static String songName = "";
    private static String artist = "";
    private static String genre = "";
    private static Integer highscore = 0;
    private static String path = "resources/test.png";

    public PlayComponent() {

    }

    public static void changeSong(Song song) {
        songName = song.getName();
        artist = song.getArtist();
        genre = song.getGenre().toString().replace("_", " ");
        genre = genre.replace(genre.charAt(0), Character.toUpperCase(genre.charAt(0)));
        highscore = song.getHighScore();
        path = song.getFile();
    }

    public static void createPlayComponent(JPanel screen) {
        screen.setLayout(new GridBagLayout());
        screen.setAlignmentX(Component.LEFT_ALIGNMENT);
        screen.setPreferredSize(new Dimension(300,250));
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.NONE;
        JLabel songNameLabel = new JLabel("Song: " + songName, SwingConstants.LEFT);
        JLabel artistLabel = new JLabel("Artist: " + artist, SwingConstants.LEFT);
        JLabel genreLabel = new JLabel("Genre: " + genre, SwingConstants.LEFT);
        JLabel highScoreLabel = new JLabel("Highscore: " + highscore.toString(), SwingConstants.LEFT);
        JLabel imageLabel = new JLabel(new ImageIcon(path), SwingConstants.LEFT);
        JButton playButton = new JButton("Play", new ImageIcon("resources/icons/play_guitar.png"));
        Border border = BorderFactory.createEmptyBorder();
        playButton.setBorder(border);
        playButton.setFocusPainted(false);

        Font font = songNameLabel.getFont().deriveFont(18.0f);
        songNameLabel.setFont(font);
        artistLabel.setFont(font);
        genreLabel.setFont(font);
        highScoreLabel.setFont(font);
        constraints.weightx = 0.3;
        constraints.weighty = 0.3;
        constraints.ipadx = 20;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 5;
        constraints.anchor = GridBagConstraints.EAST;
        screen.add(imageLabel, constraints);
        constraints.anchor = GridBagConstraints.WEST;
        constraints.gridheight = 1;
        constraints.gridx = 1;
        constraints.gridy = 0;
        screen.add(songNameLabel, constraints);
        constraints.gridy = 1;
        screen.add(artistLabel, constraints);
        constraints.gridy = 2;
        screen.add(genreLabel, constraints);
        constraints.gridy = 3;
        screen.add(highScoreLabel, constraints);
        constraints.gridy = 4;
        screen.add(playButton, constraints);
    }



}
