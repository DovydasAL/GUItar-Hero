package com.guitarhero.entity;

import javax.imageio.ImageIO;
import javax.sound.midi.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Song {

    public enum Genre {
        ROCK, HIP_HOP, COUNTRY, METAL
    }

    private String name;
    private String artist;
    private Genre genre;
    private Note firstNote;
    private Integer highScore = 0;
    private String path = "resources/test.png";
    private String image = "resources/test.png";

    private static final String green = "G";
    private static final String red = "R";
    private static final String yellow = "Y";
    private static final String blue = "B";
    private static final String orange = "O";

    private static HashMap<Integer, String> noteMap = new HashMap<>();

    public Song(String name, String artist, Genre genre) {
        if (noteMap.isEmpty()) {
            noteMap.put(96, "G");
            noteMap.put(97, "R");
            noteMap.put(98, "Y");
            noteMap.put(99, "B");
            noteMap.put(100, "O");
        }
        this.name = name;
        this.artist = artist;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public Genre getGenre() {
        return genre;
    }

    public Integer getHighScore() {
        return highScore;
    }

    public void setHighScore(Integer highScore) {
        this.highScore = highScore;
    }

    public String getFile() {
        return path;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setFirstNote(Note firstNote) {
        this.firstNote = firstNote;
    }

    public static Track filter(Track track) {
        for (int i=0;i<track.size();i++) {
            MidiEvent midiEvent = track.get(i);
            MidiMessage midiMessage = midiEvent.getMessage();
            if (!(midiMessage instanceof ShortMessage)) {
                track.remove(midiEvent);
                i--;
            }
            else if (((ShortMessage)  midiMessage).getData2() == 0) {
                track.remove(midiEvent);
                i--;
            }
        }
        return track;
    }

    public static Song constructSong(String name, String artist, Genre genre, File file, String image) {
        Song song = new Song(name, artist, genre);
        song.setImage(image);
        Sequence sequence;
        try {
            sequence = MidiSystem.getSequence(file);
        } catch (InvalidMidiDataException | IOException e) {
            return null;
        }
        final int trackNumber = 1;
        Track track = sequence.getTracks()[trackNumber];
        Note head = new Note();
        Note position = head;
        track = filter(track);
        for (int i=0;i<track.size();i++) {
            MidiEvent midiEvent = track.get(i);
            long timestamp = midiEvent.getTick();
            int j = i;
            while (j < track.size() && track.get(j).getTick() == timestamp) {
                MidiEvent colorEvent = track.get(j);
                ShortMessage colorMessage = (ShortMessage) colorEvent.getMessage();
                String color = noteMap.get(colorMessage.getData1());
                switch (color) {
                    case green:
                        position.setGreen(true);
                        break;
                    case red:
                        position.setRed(true);
                        break;
                    case yellow:
                        position.setYellow(true);
                        break;
                    case blue:
                        position.setBlue(true);
                        break;
                    case orange:
                        position.setOrange(true);
                        break;
                }
                j++;
            }
            i = j - 1;
            position.setNextNote(new Note());
            position.setTimestamp(timestamp);
            position = position.getNextNote();
        }
        song.setFirstNote(head);
        return song;

    }
}
