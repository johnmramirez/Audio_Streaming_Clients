package model;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public abstract class Audio {

    private String title;
    private String artist;
    private String album;
    private String length;
    private String id;

    protected AudioInputStream inputStream;
    protected AudioFormat audioFormat;
    protected SourceDataLine sourceDataLine;
    protected DataLine.Info info;

    protected static final int BUFFER_SIZE = 4096;

    public void init(){
        //update inputstream here? or in controller?
        // this.audioFormat = this.inputStream.getFormat();
        // this.info = new DataLine.Info(Clip.class, audioFormat);
        System.out.println("Audio.Init() called.");
    }

    public abstract void play() throws IOException, LineUnavailableException;

    public abstract void stop() throws IOException;

    public void setTitle(String title){
        this.title = title;
    }

    public void setArtist(String artist){
        this.artist = artist;
    }

    public void setAlbum(String album){
        this.album = album;
    }

    public void setLength(String length){
        this.length = length;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getTitle(){
        return this.title;
    }

    public String getArtist(){
        return this.artist;
    }

    public String getAlbum(){
        return this.album;
    }

    public String getLength(){
        return this.length;
    }

    public String getId(){
        return this.id;
    }

}