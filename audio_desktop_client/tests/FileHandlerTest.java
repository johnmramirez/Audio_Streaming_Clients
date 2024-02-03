package tests;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;

import model.FileHandler;

public class FileHandlerTest {

    static FileHandler fileHandler;

    @BeforeAll
    public static void setup(){
        fileHandler = new FileHandler();
    }

    @Test
    void shouldReturnNonNullFileInputStream() {
        try {
            FileInputStream fileInputStream = fileHandler.getFile("./files/test1.txt");
            assertNotEquals(null, fileInputStream);
            if(fileInputStream != null){
                fileInputStream.close();
            }
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    @Test
    void givenNonExistentFileShouldThrowFileNotFoundException() {
        FileNotFoundException exception = assertThrows(FileNotFoundException.class, () -> { fileHandler.getFile("./files/test2.txt");});
    }

    @Test
    void givenNullFilePathShouldThrowNullPointerException() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> { fileHandler.getFile(null);});
    }

    @Test
    void givenEmptyFilePathShouldThrowNullPointerException() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> { fileHandler.getFile("");});
    }

    @Test
    void givenWhiteSpaceFilePathShouldThrowNullPointerException() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> { fileHandler.getFile("   ");});
    }

}
