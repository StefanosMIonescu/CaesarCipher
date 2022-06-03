public class CaesarCipher {
    //Fields Should be private access only to class!
    //"ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;
    public CaesarCipher() {
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(mainKey)
                + alphabet.substring(0, mainKey);

    }
    //method declarations verbs! helpers should be private ,interface should be public
    public String getShiftedAlphabet() {
        return shiftedAlphabet;
    }

    public void setShiftedAlphabet(String shiftedAlphabet) {
        this.shiftedAlphabet = shiftedAlphabet;
    }

    public String getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(String alphabet) {
        this.alphabet = alphabet;
    }

    public int getMainKey() {

        return mainKey;
    }

    public void setMainKey(int newMainKey) {

        this.mainKey = newMainKey;
    }

    //String message ="At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
    //To  restore message encrypt again with 26-encryption key sp decrypt key = 26- key!
    public String encryptWithOneKey(String message) {
        StringBuilder sB = new StringBuilder(message);

        for (int i = 0; i < sB.length(); i++) {
            char currentChar = sB.charAt(i);

            if (Character.isLowerCase(currentChar)) {
                int indexOfCharInAlphabet = alphabet.toLowerCase().indexOf(currentChar);
                if (indexOfCharInAlphabet != -1) {
                    currentChar = shiftedAlphabet.toLowerCase().charAt(indexOfCharInAlphabet);
                    sB.setCharAt(i, currentChar);
                }
            } else if (Character.isUpperCase(currentChar)) {
                int indexOfCharInAlphabet = alphabet.toUpperCase().indexOf(currentChar);
                if (indexOfCharInAlphabet != -1) {
                    currentChar = shiftedAlphabet.toUpperCase().charAt(indexOfCharInAlphabet);
                    sB.setCharAt(i, currentChar);
                }
            }
        }
        return sB.toString();
    }

    public String encryptWithOneKeyOOP(String message, int incryptionKey) {

        CaesarCipher cipherCaesar = new CaesarCipher();
        cipherCaesar.setMainKey(incryptionKey);
        String alphabet = cipherCaesar.getAlphabet();
        cipherCaesar.setShiftedAlphabet(alphabet.substring(incryptionKey) + alphabet.substring(0, incryptionKey));
        String shiftedAlphabet = cipherCaesar.getShiftedAlphabet();
        String encryptedMessageOneKey = cipherCaesar.encryptWithOneKey(message);
        System.out.println("The original message is : " + message);
        System.out.println("The encrypted message is : " + encryptedMessageOneKey);
        return encryptedMessageOneKey;
    }

    // encrypt with 2 encryption one for odds one for even charactes depending on distance from start
    public static String encryptWithTwoKeys(String message, int keyEven, int keyOdd) {

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder encrypted = new StringBuilder(message);
        CaesarCipher cipherEven = new CaesarCipher();
        cipherEven.setMainKey(keyEven);
        cipherEven.setShiftedAlphabet(alphabet.substring(keyEven) + alphabet.substring(0, keyEven));
        String shiftedEven = cipherEven.getShiftedAlphabet();
        CaesarCipher cipherOdd = new CaesarCipher();
        cipherOdd.setMainKey(keyOdd);
        cipherOdd.setShiftedAlphabet(alphabet.substring(keyOdd) + alphabet.substring(0, keyOdd));
        String shiftedOdd = cipherOdd.getShiftedAlphabet();
        int currentIndex = 0;
        //!!!!!You want to compare the index of the for loop not the idx if it is odd! so save the currentIndex outside:P
        for (int i = 0; i < message.length(); i++) {
            char currChar = message.charAt(i);
            //Even
            if (currentIndex % 2 == 0) {
                int idx;
                if (Character.isLowerCase(currChar)) {
                    idx = alphabet.toLowerCase().indexOf(currChar);
                    if (idx != -1) {
                        char newChar = shiftedEven.toLowerCase().charAt(idx);
                        encrypted.setCharAt(i, newChar);
                    }
                } else {
                    idx = alphabet.indexOf(currChar);
                    if (idx != -1) {
                        char newChar = shiftedEven.charAt(idx);
                        encrypted.setCharAt(i, newChar);
                    }
                }
            }
            else {
                //ODD
                int idx;
                if (Character.isLowerCase(currChar)) {
                    idx = alphabet.toLowerCase().indexOf(currChar);
                    if (idx != -1) {
                        char newChar = shiftedOdd.toLowerCase().charAt(idx);
                        encrypted.setCharAt(i, newChar);
                    }
                } else {
                    idx = alphabet.indexOf(currChar);
                    if (idx != -1) {
                        char newChar = shiftedOdd.charAt(idx);
                        encrypted.setCharAt(i, newChar);
                    }
                }
            }
            currentIndex++;
        }
        return encrypted.toString();
    }
}
