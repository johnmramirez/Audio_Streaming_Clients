package model;

import javax.sound.sampled.AudioInputStream;

public class WAV extends Audio {

    public WAV(AudioInputStream audioInputStream){
        this.audioInputStream = audioInputStream;
    }

    public WAV(AudioInputStream audioInputStream, String title, String artist, String album, String length, String id){
        this.audioInputStream = audioInputStream;
        this.setTitle(title);
        this.setArtist(artist);
        this.setAlbum(album);
        this.setLength(length);
        this.setId(id);
    }
    
}
