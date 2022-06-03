import data.WordEdit;
import java.util.ArrayList;

public class CeasarBreakerTwoKeys {

    private String alphabet;
    private String shiftedAlphabetEven;
    private String shiftedAlphabetOdd;
    private int keyEven;
    private int keyOdd;

    public CeasarBreakerTwoKeys() {

        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabetEven = alphabet.substring(keyEven)
                + alphabet.substring(0, keyEven);
        shiftedAlphabetOdd = alphabet.substring(keyOdd)
                + alphabet.substring(0, keyOdd);

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

    public int getKeyOdd() {
        return keyOdd;
    }

    public void setKeyOdd(int keyOdd) {
        this.keyOdd = keyOdd;
    }

    public String getShiftedAlphabetEven() {
        return shiftedAlphabetEven;
    }

    public void setShiftedAlphabetEven(String shiftedAlphabetEven) {
        this.shiftedAlphabetEven = shiftedAlphabetEven;
    }

    public String getShiftedAlphabetOdd() {
        return shiftedAlphabetOdd;
    }

    public void setShiftedAlphabetOdd(String shiftedAlphabetOdd) {
        this.shiftedAlphabetOdd = shiftedAlphabetOdd;
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

    public static String decryptWithTwoKeys(String encrypted) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String evenMessage = WordEdit.getStringEvenOrOddPart(encrypted, 0);
        String oddMessage = WordEdit.getStringEvenOrOddPart(encrypted, 1);
        //  location of mostCommonCharOfTheEncryptedAlphabet of EvenMessage
        int keyEven = getKey(evenMessage);
        String evenMessageDecrypted = decryptFromEven(evenMessage,keyEven);
        int dkeyEven = getDecryptionKey(keyEven);
        //  location of mostCommonCharOfTheEncryptedAlphabet of OddMessage
        int keyOdd = getKey(oddMessage);
        String oddMessageDecrypted = decryptFromOdd(oddMessage,keyOdd);
        int dkeyOdd = getDecryptionKey(keyOdd);
        String decryptedMessage = CaesarCipherTwoKeys.encryptWithTwoKeys(encrypted, dkeyEven, dkeyOdd);
        return    decryptedMessage    ;

    }

    public static int getKey(String encrypted) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        ArrayList<Integer>counts =WordEdit.getCountOfCharacters(encrypted);
        int intOfMostCommon = WordEdit.getMaxIndex(counts);
        ArrayList<Integer> frequenciesOfCharacters = WordEdit.getCountOfCharacters(encrypted);
        int mostCommonCharIndex = WordEdit.getMaxIndex(frequenciesOfCharacters);
        return mostCommonCharIndex;
    }

    public static int getDecryptionKey(int key) {

        int decriptionKey = key - 4;
        if (key < 4) {

            decriptionKey = 26 - (4 - key);
        }
        return 26 - decriptionKey;
    }
    public static String decryptFromEven(String evenMessage, int keyEven) {

        CaesarCipher cipherCaesar = new CaesarCipher();
        cipherCaesar.setMainKey(keyEven);
        String alphabet = cipherCaesar.getAlphabet();
        cipherCaesar.setShiftedAlphabet(alphabet.substring(keyEven) + alphabet.substring(0, keyEven));
        String shiftedAlphabet = cipherCaesar.getShiftedAlphabet();
        String encryptedMessageOneKey = cipherCaesar.encryptWithOneKeyOOP(evenMessage,keyEven);
        System.out.println("The original Even message is : " + evenMessage);
        System.out.println("The encrypted Even message is : " + encryptedMessageOneKey);
        return encryptedMessageOneKey;
    }
    public static String decryptFromOdd(String oddMessage, int keyOdd) {

        CaesarCipher cipherCaesar = new CaesarCipher();
        cipherCaesar.setMainKey(keyOdd);
        String alphabet = cipherCaesar.getAlphabet();
        cipherCaesar.setShiftedAlphabet(alphabet.substring(keyOdd) + alphabet.substring(0, keyOdd));
        String shiftedAlphabet = cipherCaesar.getShiftedAlphabet();
        String encryptedMessageOneKey = cipherCaesar.encryptWithOneKeyOOP(oddMessage,   keyOdd);

        System.out.println("The original Odd message is : " + oddMessage);
        System.out.println("The encrypted  Odd message is : " + encryptedMessageOneKey);
        return encryptedMessageOneKey;
    }
    public static char getMostCommonChar(String encrypted) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        ArrayList<Integer>counts =WordEdit.getCountOfCharacters(encrypted);
        int intOfMostCommon = WordEdit.getMaxIndex(counts);
        char mostCommonChar = alphabet.charAt(intOfMostCommon);
        ArrayList<Integer> frequenciesOfCharacters = WordEdit.getCountOfCharacters(encrypted);

        return mostCommonChar;
    }
    public static void BruteCeasarCipehr2keys(String phrase) {

        int keyOdd = 0;
        int keyEven = 0;
        CaesarCipherTwoKeys cipherTwoKeys=new CaesarCipherTwoKeys();

        String oddMessage;
        String evenMessage;
        String originalMessage = cipherTwoKeys.encryptWithTwoKeys(phrase,26- keyOdd, 26-keyEven);

        for (int i = 0; i < 26; i++) {
            keyOdd=0;
            for (int j = 0; j < 26; j++) {
                System.out.println("The message is "+cipherTwoKeys.encryptWithTwoKeys(phrase,26-keyEven ,26-keyOdd )+ " with Evenkey "+keyEven+ " OddKey "+keyOdd);
                keyOdd++;
            }
            keyEven++;
        }
    }
}

