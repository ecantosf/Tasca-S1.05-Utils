package utilities.basic;

import java.io.IOException;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class TXTFileReader {

    public void readAndShow(String filePath, String fileName) {
        Path pathSearched = Paths.get(filePath, fileName);

        try (BufferedReader br = Files.newBufferedReader(pathSearched)){
            String line;
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e){
            System.out.println("Error reading file " + e.getMessage());
        }
    }

    }