package controller;

import java.util.ArrayList;

import model.Audio;
import model.AudioPlayer;
import model.AudioRetriever;
import view.AudioPlayerView;

public class Controller {

    private final String ERROR_MSG = "An error has occurred.";

    private AudioPlayerView audioPlayerView;
    private AudioPlayer audioPlayer;
    private AudioRetriever audioRetriever;

    public Controller(){
        this.audioPlayerView = new AudioPlayerView();
        this.audioPlayer = new AudioPlayer();
        this.audioRetriever = new AudioRetriever();
    }

    public void setSong(String songName){
        try {
            Audio song = this.audioRetriever.getSong(songName);
            this.audioPlayer.setSong(song);
        } catch (Exception e){
            this.audioPlayerView.printToConsole(ERROR_MSG);
            e.printStackTrace();
        }
    }

    public void playSong(){
        try {
            this.audioPlayer.playSong();
        } catch (Exception e) {
            this.audioPlayerView.printToConsole(ERROR_MSG);
            e.printStackTrace();
        }
    }

    public void stopSong(){
        try {
            this.audioPlayer.stopSong();
        } catch (Exception e){
            this.audioPlayerView.printToConsole(ERROR_MSG);
            e.printStackTrace();
        }
    }

    public boolean songSelected(){
        return (this.audioPlayer.getSong() != null);
    }

    public void printSelectedSongDetails(){
        this.audioPlayerView.printToConsole(this.audioPlayer.getSong().toString());
    }

    public void printAvailableSongs(String directory){
        ArrayList<String> songs = this.audioRetriever.getAvailableSongs(directory);
        for (String song : songs) {
            this.audioPlayerView.printToConsole(song);
        }
    }

    public void printHelpDetails(String... helpDetails){
        this.audioPlayerView.printToConsole(helpDetails);
    }

}
