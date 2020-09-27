package dk.kea;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TextReader {

    private StringBuilder text;

    public TextReader(String path){
        File file = new File(path);
        BufferedReader br;
        text = new StringBuilder();
        try {
            br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null)
                text.append(st).append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getText() {
        return text.toString();
    }
}

