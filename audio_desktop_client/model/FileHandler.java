package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class FileHandler {
    
    public FileInputStream getFile(String filepath) throws FileNotFoundException, NullPointerException {
        if(filepath.isBlank()){
            throw new NullPointerException("Filepath is an empty string or only contains space characters.");
        }
        File file = new File(filepath);
        FileInputStream fileInputStream = new FileInputStream(file);
        return fileInputStream;
    }

    public ArrayList<String> getFilePaths(String directory){
        ArrayList<String> filepaths = new ArrayList<>();
        File[] files = new File(directory).listFiles();
        for (File file : files) {
            if(!file.isDirectory()){
                filepaths.add(file.getAbsolutePath());
            }
        }
        return filepaths;
    }

}
