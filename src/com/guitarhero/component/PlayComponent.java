package com.guitarhero.component;

import com.guitarhero.entity.Song;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
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
        screen.setLayout(new BoxLayout(screen, BoxLayout.X_AXIS));
        screen.setPreferredSize(new Dimension(300,150));
        screen.setAlignmentX(Component.LEFT_ALIGNMENT);
        JLabel songNameLabel = new JLabel("Song: " + songName, SwingConstants.LEFT);
        JLabel artistLabel = new JLabel("Artist: " + artist, SwingConstants.LEFT);
        JLabel genreLabel = new JLabel("Genre: " + genre, SwingConstants.LEFT);
        JLabel highScoreLabel = new JLabel("Highscore: " + highscore.toString(), SwingConstants.LEFT);
        JLabel imageLabel = new JLabel(new ImageIcon(path), SwingConstants.LEFT);
        artistLabel.setBorder(new EmptyBorder(10,0,0,0));
        genreLabel.setBorder(new EmptyBorder(10,0,0,0));
        highScoreLabel.setBorder(new EmptyBorder(10,0,0,0));
        imageLabel.setBorder(new EmptyBorder(10,0,0,0));
        JButton playButton = new JButton("Play", new ImageIcon("resources/icons/play_guitar.png"));
        playButton.setFocusPainted(false);
        Font font = songNameLabel.getFont().deriveFont(14.0f);
        songNameLabel.setFont(font);
        artistLabel.setFont(font);
        genreLabel.setFont(font);
        highScoreLabel.setFont(font);
        playButton.setFont(font);
        screen.add(imageLabel);
        JPanel rightPanel = new JPanel();
        rightPanel.setBorder(new EmptyBorder(0,20,0,0));
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.add(songNameLabel);
        rightPanel.add(artistLabel);
        rightPanel.add(genreLabel);
        rightPanel.add(highScoreLabel);
        rightPanel.add(playButton);
        screen.add(rightPanel);
    }



}
