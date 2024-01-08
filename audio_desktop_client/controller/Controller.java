package controller;
import java.util.ArrayList;

import model.Audio;
import view.AudioPlayerView;

public class Controller {
    private AudioPlayerView audioPlayerView;
    private Audio song = null;
    private ArrayList<Audio> songs = null;

    public Controller(AudioPlayerView audioPlayerView){
        this.audioPlayerView = audioPlayerView;
    }

    public void setSong(Audio song){
        this.song = song;
    }

    public Audio getSong(){
        return this.song;
    }

    public Audio downloadSong(String songId){
        return null;
    }

    public ArrayList<Audio> downloadSongs(){
        return null;
    }

    //Audio object should be responsible for returning toString for printing
    public void printSelectedSongDetails(){
        this.audioPlayerView.printSongDetails(this.song);
    }

    public void printAvailableSongs(){
        this.audioPlayerView.printAvailableSongs(this.songs);
    }

}
