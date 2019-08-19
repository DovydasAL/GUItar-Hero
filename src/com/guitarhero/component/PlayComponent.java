package com.guitarhero.component;

import com.guitarhero.entity.Song;

import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.*;

public class PlayComponent {

    private static String songName = "";
    private static String artist = "";
    private static String genre = "";
    private static Integer highscore = 0;
    private static String path = "resources/test.png";
    private static JPanel parent = null;
    private static Clip clip = null;

    public PlayComponent() {
    	
    }

    public static void changeSong(Song song) {
        songName = song.getName();
        artist = song.getArtist();
        genre = song.getGenre().toString().replace("_", " ");
        genre = genre.replace(genre.charAt(0), Character.toUpperCase(genre.charAt(0)));
        highscore = song.getHighScore();
        path = song.getImage();
        updateText();
        playSong(song.getWavFile());
    }

    public static void playSong(String file) {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
        try {
            File wavFile = new File(file);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(wavFile);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            return;
        }

    }

    public static void updateText() {
        JPanel rightPanel = (JPanel) parent.getComponent(1);
        ((JLabel) rightPanel.getComponent(0)).setText("Song: " + songName);
        ((JLabel) rightPanel.getComponent(1)).setText("Artist: " + artist);
        ((JLabel) rightPanel.getComponent(2)).setText("Genre: " + genre);
        ((JLabel) rightPanel.getComponent(3)).setText("Highscore: " + highscore);
        ((JLabel) parent.getComponent(0)).setIcon(new ImageIcon(path));
    }

    public static void createPlayComponent(JPanel screen) throws FontFormatException, IOException {
        parent = screen;
        parent.setLayout(new BoxLayout(screen, BoxLayout.X_AXIS));
        parent.setPreferredSize(new Dimension(500,200));
        parent.setAlignmentX(Component.LEFT_ALIGNMENT);
        parent.setBackground(new Color(229,123,57));
        JLabel songNameLabel = new JLabel("Song: " + songName, SwingConstants.LEFT);
        JLabel artistLabel = new JLabel("Artist: " + artist, SwingConstants.LEFT);
        JLabel genreLabel = new JLabel("Genre: " + genre, SwingConstants.LEFT);
        JLabel highScoreLabel = new JLabel("Highscore: " + highscore.toString(), SwingConstants.LEFT);
        JLabel imageLabel = new JLabel(new ImageIcon(path), SwingConstants.LEFT);
        artistLabel.setBorder(new EmptyBorder(10,0,0,0));
        genreLabel.setBorder(new EmptyBorder(10,0,0,0));
        highScoreLabel.setBorder(new EmptyBorder(10,0,10,0));
        JButton playButton = new JButton("Play", new ImageIcon("resources/icons/play_guitar.png"));
        playButton.setFocusPainted(false);
        playButton.setBorderPainted(false);
        playButton.setFocusPainted(false);
        playButton.setBackground(null);
        playButton.setMargin(new Insets(0,190,0,0));
        Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("resources/fonts/Roddenberry Italic.ttf"));
        
        songNameLabel.setFont(customFont.deriveFont(20.0f));
        artistLabel.setFont(customFont.deriveFont(20.0f));
        genreLabel.setFont(customFont.deriveFont(20.0f));
        highScoreLabel.setFont(customFont.deriveFont(20.0f));
        playButton.setFont(customFont.deriveFont(20.0f));
        parent.add(imageLabel,0);
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(new Color(229,123,57));
        rightPanel.add(Box.createHorizontalGlue());
        rightPanel.setBorder(new EmptyBorder(0,20,0,0));
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.add(songNameLabel, 0);
        rightPanel.add(artistLabel, 1);
        rightPanel.add(genreLabel, 2);
        rightPanel.add(highScoreLabel,3 );
        rightPanel.add(playButton, 4);
        parent.add(Box.createVerticalGlue());
        parent.add(rightPanel, 1);
    }



}
