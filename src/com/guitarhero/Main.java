package com.guitarhero;

import com.guitarhero.entity.Song;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        File file = new File("../eof/Lil Tecca - Ransom/notes.mid");
	    Song song = Song.constructSong("Ransom", "Lil Tecca", file);
	    System.out.println("Test");
    }
}
