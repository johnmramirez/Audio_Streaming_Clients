package view;
import java.util.ArrayList;

import model.Audio;

public class AudioPlayerView {
    
    public void printSongDetails(Audio song){
        if(song != null){
            System.out.printf("Id: %s\n", song.getId());
            System.out.printf("Song Name: %s\n", song.getTitle());
            System.out.printf("Song Length: %s\n", song.getLength());
            System.out.printf("Artist: %s\n", song.getArtist());
            System.out.printf("Album: %s\n\n", song.getAlbum());
        } else {
            System.out.println("No song has been selected.");
        }
    }

    public void printAvailableSongs(ArrayList<Audio> songList){
        if(songList != null){
            for (Audio audio : songList) {
                this.printSongDetails(audio);
            }
        } else {
            System.out.println("No available songs to preview.");
        }
    }

}
