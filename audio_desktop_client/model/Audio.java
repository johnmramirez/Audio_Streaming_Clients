package model;

import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

public abstract class Audio {

    private String title;
    private String artist;
    private String album;
    private String length;
    private String format;
    private String id;

    protected AudioInputStream audioInputStream;
    protected SourceDataLine sourceDataLine;

    protected static final int BUFFER_SIZE = 4096;

    public void play() throws IOException, LineUnavailableException {
        System.out.printf("Playing %s %s.\n", this.getFormat(), this.getTitle());
        AudioFormat format = this.audioInputStream.getFormat();
        DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
        this.sourceDataLine = (SourceDataLine) AudioSystem.getLine(info);
        this.sourceDataLine.open(format);
        this.sourceDataLine.start();

        byte[] buffer = new byte[BUFFER_SIZE];
        int read = -1;
        while ((read = this.audioInputStream.read(buffer)) != -1){
            this.sourceDataLine.write(buffer, 0, read);
        }
        this.stop();
    }

    public void stop() throws IOException {
        System.out.printf("Stopping %s %s.\n", this.getFormat(), this.getTitle());
        this.sourceDataLine.drain();
        this.sourceDataLine.stop();
        this.audioInputStream.close();
    }

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

    public void setFormat(String format){
        this.format = format;
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

    public String getFormat(){
        return this.format;
    }

    public String getId(){
        return this.id;
    }

    @Override
    public String toString(){
        return "Title=" + this.getTitle() +
            ", Artist=" + this.getArtist() +
            ", Album=" + this.getAlbum() +
            ", Length=" + this.getLength() +
            ", Format=" + this.getFormat() +
            ", Id=" + this.getId();
    }

}