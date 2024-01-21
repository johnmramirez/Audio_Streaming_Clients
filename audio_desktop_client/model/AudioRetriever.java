package model;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.regex.Pattern;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioRetriever {

    private FileHandler fileHandler;
    private AudioParser audioParser;
    private Map<String, String> availableSongs;

    public AudioRetriever(){
        this.fileHandler = new FileHandler();
        this.audioParser = new AudioParser();
        this.availableSongs = new Hashtable<String, String>();
    }
    
    public Audio getSong(String songName) throws FileNotFoundException, IOException, UnsupportedAudioFileException {
        String filepath = this.availableSongs.get(songName);
        WAV song = null;
        if(filepath != null){
            FileInputStream fileInputStream = this.fileHandler.getFile(filepath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(fileInputStream));
            song = new WAV(audioInputStream);
        }
        return song;
    }

    public ArrayList<String> getAvailableSongs(String directory){
        if(this.availableSongs.isEmpty()){
            ArrayList<String> filepaths = this.fileHandler.getFilePaths(directory);
            for (String filepath : filepaths) {
                String[] tokens = filepath.replaceAll(Pattern.quote("\\"), "\\\\").split("\\\\");
                this.availableSongs.put(tokens[tokens.length - 1], filepath);
            }
        }
        return new ArrayList<String>(this.availableSongs.keySet());
    }

}
