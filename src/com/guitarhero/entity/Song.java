package com.guitarhero.entity;

import javax.sound.midi.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Song {
    private String name;
    private String artist;
    private Note firstNote;

    private static final String green = "G";
    private static final String red = "R";
    private static final String yellow = "Y";
    private static final String blue = "B";
    private static final String orange = "O";

    private static HashMap<Integer, String> noteMap = new HashMap<>();

    public Song(String name, String artist) {
        if (noteMap.isEmpty()) {
            noteMap.put(96, "G");
            noteMap.put(97, "R");
            noteMap.put(98, "Y");
            noteMap.put(99, "B");
            noteMap.put(100, "O");
        }
        this.name = name;
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
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

    public static Song constructSong(String name, String artist, File file) {
        Song song = new Song(name, artist);
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
