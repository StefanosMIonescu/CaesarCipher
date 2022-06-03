import data.WordEdit;

import java.util.ArrayList;


public class CaesarBreaker {

    private String alphabet;
    private String shiftedAlphabetEven;
    private int keyEven;

    public CaesarBreaker() {

        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabetEven = alphabet.substring(keyEven)
                + alphabet.substring(0, keyEven);

    }

    public void setAlphabet(String alphabet) {
        this.alphabet = alphabet;
    }

    public String getAlphabet() {
        return alphabet;
    }

    public int getKeyEven() {
        return keyEven;
    }

    public void setKeyEven(int keyEven) {
        this.keyEven = keyEven;
    }

    public String getShiftedAlphabetEven() {
        return shiftedAlphabetEven;
    }

    public void setShiftedAlphabetEven(String shiftedAlphabetEven) {
        this.shiftedAlphabetEven = shiftedAlphabetEven;
    }

    public static void getDecryptedBruteForceOneKey(String encrypted) {
        CaesarCipher cipher = new CaesarCipher();

        for (int i = 0; i < 26; i++) {

            String decryptionAttempt = cipher.encryptWithOneKeyOOP(encrypted, i);
            System.out.println("The key is i : " + i + " and the decrypted message is : " + decryptionAttempt);
        }
    }

    public static String decrypt(String encrypted) {
        CaesarCipher caesarCipher = new CaesarCipher();
        ArrayList<Integer> frequenciesOfCharacters = WordEdit.getCountOfCharacters(encrypted);
        int mostCommonCharIndex = WordEdit.getMaxIndex(frequenciesOfCharacters);
        // int 4 = e is the most common char in english language for russian its 0 is 14
        int distanceShift = mostCommonCharIndex - 4;
        if (mostCommonCharIndex < 4) {
            distanceShift = 26 - (4 - mostCommonCharIndex);
        }
        return caesarCipher.encryptWithOneKeyOOP(encrypted, 26 - distanceShift);
    }

    //location of mostCommonCharOfTheEncryptedAlphabet
    public static int getKey(String encrypted) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //counts[]
        ArrayList<Integer> frequenciesOfCharacters = WordEdit.getCountOfCharacters(encrypted);
        int mostCommonCharIndex = WordEdit.getMaxIndex(frequenciesOfCharacters);
        int mostCommonCharOfAlphabet = frequenciesOfCharacters.get(mostCommonCharIndex);
        return mostCommonCharOfAlphabet;

    }

    public static char getMostCommonChar(String encrypted) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //counts[]
        ArrayList<Integer> frequenciesOfCharacters = WordEdit.getCountOfCharacters(encrypted);
        int mostCommonCharIndex = WordEdit.getMaxIndex(frequenciesOfCharacters);
        int mostCommonCharOfAphabet = frequenciesOfCharacters.get(mostCommonCharIndex);
        char commonChar = alphabet.charAt(mostCommonCharIndex);
        return commonChar;
    }

    public static int getDecryptionKey(int key) {
        // key is the most frequent character found in the encrypted message
        int decryptionKey = key - 4;
        //the decryption key is the absolute shift /distance of original letter to shifted letter
        if (key < 4) {

            decryptionKey = 26 - (4 - key);
        }
        return 26 - decryptionKey;
    }

}



