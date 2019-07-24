package com.guitarhero.entity;

import javax.sound.midi.*;
import java.io.File;
import java.io.IOException;

public class Song {
    private String name;
    private String artist;
    private Note firstNote;

    public static final int ON = 0x90;
    public static final int OFF = 0x80;

    public Song(String name, String artist) {
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
            }
            ShortMessage shortMessage = (ShortMessage) midiMessage;
            if (shortMessage.getCommand() == OFF) {
                track.remove(midiEvent)
            }
            i--;
        }
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
        Note head = new Note(false,false,false,false,false,0);
        Note position = head;
        track = filter(track);
        for (int i=0;i<track.size();i++) {
            
        }

    }
}
