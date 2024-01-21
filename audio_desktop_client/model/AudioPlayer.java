package model;

import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;

public class AudioPlayer {

    private Audio currentSong = null;

    public void setSong(Audio song){
        this.currentSong = song;
    }

    public Audio getSong(){
        return this.currentSong;
    }
    
    public void playSong() throws IOException, LineUnavailableException{
        this.currentSong.play();
    }

    public void stopSong() throws IOException{
        if(this.currentSong != null){
            this.currentSong.stop();
        }
    }

}
