package dk.kea;

import java.util.List;

public class Crypto {

    private List<Character> letterList;

    public Crypto() {
        LetterManager letterManager = new LetterManager();
        this.letterList = letterManager.getLetterList();
    }

    public String enCrypt(String message, String password){
        int[] arrayPassword = passwordShift(password);
        return shifter(message, arrayPassword);
    }

    public String deCrypt(String message, String password){
        int[] arrayPassword = passwordShift(password);
        for (int i = 0; i < arrayPassword.length; i++){
            arrayPassword[i] = arrayPassword[i] * -1;
        }
        return shifter(message, arrayPassword);
    }

    private String shifter(String message, int[] password){
        StringBuilder result = new StringBuilder();
        int tal = 0;
        for (char c : message.toCharArray()){
            int nyShift = password[tal % password.length];
            if (nyShift < 0){
                nyShift = letterList.size() - ((nyShift * -1) % letterList.size());
            }
            result.append(shiftedChar(c, nyShift));
            tal++;
        }
        return result.toString();
    }

    public int[] passwordShift(String password){
        int[] passShiftNum = new int[password.length()];
        for (int p = 0; p < password.length(); p++){
            for (int i = 0; i < letterList.size(); i++){
                if (password.charAt(p) == letterList.get(i)){
                    passShiftNum[p] = i;
                }
            }
        }
        return passShiftNum;
    }

    private char shiftedChar(char c, int shift){
        for (int i = 0; i < letterList.size(); i++){
            if (c == letterList.get(i)){
                for (int j = 0; j < letterList.size(); j++){
                    if (j == (i + shift) % letterList.size()){
                        return letterList.get(j);
                    }
                }
            }
        }
        return c;
    }
}
