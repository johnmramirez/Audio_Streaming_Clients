import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.LineUnavailableException;

import controller.Controller;

public class AudioPlayerApplication {

    public static final String PLAY_CMD_DESCRIPTION = "\"play\": plays the currently selected song.";
    public static final String STOP_CMD_DESCRIPTION = "\"stop\": stops playing the currently selected song.";
    public static final String PRINT_ALL_CMD_DESCRIPTION = "\"print --all\": prints information about all songs.";
    public static final String PRINT_CMD_DESCRIPTION = "\"print\": prints information about the currently selected song.";
    public static final String SELECT_CMD_DESCRIPTION = "\"select <songName>\": sets the song with songName as the currently selected song.";
    public static final String INVALID_COMMAND_DESCRIPTION = "Invalid Command.";
    public static final String MUST_SELECT_DESCRIPTION = "A song must be selected. Enter \"print --all\" to display a list of available songs.";


    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        String input, cmd;
        String[] tokens;

        Controller controller = new Controller();

        System.out.println("Welcome to the AudioPlayer. Type \"help\" for a list of commands.");
        System.out.print("$ ");
        input = reader.nextLine();

        while(!input.equalsIgnoreCase("exit")){
            tokens = input.split(" ");
            cmd = tokens[0];

            try {
                switch (cmd.toLowerCase()) {
                    case "play":
                        if(controller.songSelected()){
                            controller.playSong();
                        } else {
                            controller.printHelpDetails(MUST_SELECT_DESCRIPTION);
                        }
                        break;

                    case "stop":
                        if(controller.songSelected()){
                            controller.stopSong();
                        }
                        else {
                            controller.printHelpDetails(MUST_SELECT_DESCRIPTION);
                        }
                        break;

                    case "print":
                        if(tokens.length == 1){
                            if(controller.songSelected()){
                                controller.printSelectedSongDetails();
                            } else {
                                controller.printHelpDetails(MUST_SELECT_DESCRIPTION);
                            }
                            
                        }
                        else if(tokens.length == 2){
                            if (tokens[1].equalsIgnoreCase("--all")){
                                controller.printAvailableSongs("tracks");
                            } else {
                                controller.printHelpDetails(INVALID_COMMAND_DESCRIPTION);
                            }
                        } else {
                            controller.printHelpDetails(INVALID_COMMAND_DESCRIPTION);
                        }
                        break;

                    case "select":
                        if(tokens.length == 2){
                            String songName = tokens[1];
                            controller.setSong(songName);
                        }
                        break;

                    case "help":
                        controller.printHelpDetails(PLAY_CMD_DESCRIPTION, STOP_CMD_DESCRIPTION, PRINT_CMD_DESCRIPTION, 
                            PRINT_ALL_CMD_DESCRIPTION, SELECT_CMD_DESCRIPTION);
                        break;

                    default:
                        controller.printHelpDetails(INVALID_COMMAND_DESCRIPTION);
                        break;
                }
            } catch (Exception e){
                e.printStackTrace();
            }

            System.out.print("$ ");
            input = reader.nextLine();
        }

        reader.close();
    }
}
