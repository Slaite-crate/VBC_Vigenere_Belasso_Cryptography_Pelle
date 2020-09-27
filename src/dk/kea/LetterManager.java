package dk.kea;

import java.util.ArrayList;
import java.util.List;

public class LetterManager {

    private List<Character> letterList;

    public LetterManager() {
        letterList = new ArrayList<>();
        addLowerCase();
    }

    private void addLowerCase() {
        char letter = 'a';
        for (int i = 0; i < 26; i++) {
            letterList.add(letter);
            letter++;
        }
    }

    private void addUpperCase() {
        char letter = 'A';
        for (int i = 0; i < 26; i++) {
            letterList.add(letter);
            letter++;
        }
    }

    public void addLetter(char letter) {
        letterList.add(letter);
    }

    public List<Character> getLetterList() {
        return letterList;
    }
}
