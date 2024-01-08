package model;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class MP3 extends Audio {

    public MP3(String title, String artist, String album, String length, String id){
        this.setTitle(title);
        this.setArtist(artist);
        this.setAlbum(album);
        this.setLength(length);
        this.setId(id);
    }

    @Override
    public void play() throws IOException, LineUnavailableException {
        // this.stop();
        // this.init();
        // this.sourceDataLine = (SourceDataLine) AudioSystem.getLine(info);
        // sourceDataLine.open(audioFormat);
        // sourceDataLine.start();

        // byte[] bufferBytes = new byte[BUFFER_SIZE];
        // int readBytes = -1;
        // while ((readBytes = this.inputStream.read(bufferBytes)) != -1) {
        //     sourceDataLine.write(bufferBytes, 0, readBytes);
        // }
        // this.stop();
        System.out.printf("Playing %s.\n", this.getTitle());
    }

    @Override
    public void stop() throws IOException{
        // this.sourceDataLine.drain();
        // this.sourceDataLine.close();
        // this.inputStream.close();
        System.out.printf("Stopping %s.\n", this.getTitle());
    }
    
}
