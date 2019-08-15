package com.guitarhero.component;

import com.guitarhero.entity.Song;

import java.io.File;

public class PlayComponent {

    private static String songName = "Song";
    private static String artist = "Artist";
    private static String genre = "Genre";
    private static Integer highscore = 0;
    private static File file = new File("resources/test.png");

    public PlayComponent() {

    }

    public void changeSong(Song song) {
        songName = song.getName();
        artist = song.getArtist();
        genre = song.getGenre().toString().replace("_", " ");
        genre = genre.replace(genre.charAt(0), Character.toUpperCase(genre.charAt(0)));
        highscore = song.getHighScore();
    }

}
