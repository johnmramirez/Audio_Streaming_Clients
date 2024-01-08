import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.LineUnavailableException;

import controller.Controller;
import model.MP3;
import view.AudioPlayerView;

public class AudioPlayer {

    public static final String PLAY_CMD_DESCRIPTION = "\"play\": plays the currently selected song.";
    public static final String STOP_CMD_DESCRIPTION = "\"stop\": stops playing the currently selected song.";
    public static final String PRINT_ALL_CMD_DESCRIPTION = "\"print --all\": prints information about all songs.";
    public static final String PRINT_CMD_DESCRIPTION = "\"print\": prints information about the currently selected song.";
    public static final String SELECT_CMD_DESCRIPTION = "\"select --songId <songId>\": sets the song with songId as the currently selected song.";
    public static final String INVALID_COMMAND_DESCRIPTION = "Invalid Command.";
    public static final String MUST_SELECT_DESCRIPTION = "A song must be selected. Enter \"print --all\" to display a list of available songs.";

    // public enum Commands {
    //     PLAY,
    //     STOP,
    //     PRINT,
    //     SELECT,
    //     HELP,
    //     EXIT
    // }


    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        String input, cmd, cmdOption = null, cmdArg = null;
        String[] tokens;

        AudioPlayerView audioPlayerView = new AudioPlayerView();
        Controller controller = new Controller(audioPlayerView);

        System.out.println("Welcome to the AudioPlayer. Type \"help\" for a list of commands.");
        System.out.print("$ ");
        input = reader.nextLine();

        while(!input.equalsIgnoreCase("exit")){
            tokens = input.split(" ");
            cmd = tokens[0];
            if(tokens.length == 2){
                cmdOption = tokens[1];
            } else if(tokens.length == 3){
                cmdOption = tokens[1];
                cmdArg = tokens[2];
            }
            

            try {
                switch (cmd.toLowerCase()) {
                    case "play":
                        if(controller.getSong() == null){
                            System.out.println(MUST_SELECT_DESCRIPTION);
                        } else {
                            controller.getSong().play();
                        }
                        break;
                    case "stop":
                        if(controller.getSong() != null){
                            controller.getSong().stop();
                        }
                        else {
                            System.out.println(MUST_SELECT_DESCRIPTION);
                        }
                        break;
                    case "print":
                        if(cmdOption == null){
                            controller.printSelectedSongDetails();
                        } else {
                            controller.printAvailableSongs();
                        }
                        break;
                    case "select":
                        if (cmdOption != null && cmdArg != null) {
                            controller.setSong(new MP3("TestTitle","TestArtist","TestAlbum","99:99",cmdArg));
                        } else {
                            System.out.println(INVALID_COMMAND_DESCRIPTION);
                        }
                        System.out.printf("Song %s has been selected.\n", controller.getSong().getTitle());
                        break;
                    case "help":
                        System.out.println(PLAY_CMD_DESCRIPTION);
                        System.out.println(STOP_CMD_DESCRIPTION);
                        System.out.println(PRINT_CMD_DESCRIPTION);
                        System.out.println(PRINT_ALL_CMD_DESCRIPTION);
                        System.out.println(SELECT_CMD_DESCRIPTION);
                        break;
                    default:
                        System.out.println(INVALID_COMMAND_DESCRIPTION);
                        break;
                }
            } catch (IOException ioe){
                ioe.printStackTrace();
            } catch (LineUnavailableException lue){
                lue.printStackTrace();
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                cmdOption = null; cmdArg = null;
            }

            System.out.print("$ ");
            input = reader.nextLine();
        }

        reader.close();
    }
}
