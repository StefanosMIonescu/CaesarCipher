public class CaesarCipherTwoKeys {

    private String alphabet;
    private String shiftedAlphabetEven;
    private String shiftedAlphabetOdd;
    private int keyEven;
    private int keyOdd;

    public CaesarCipherTwoKeys() {

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

    public static String encryptWithTwoKeys(String message, int keyEven, int keyOdd) {

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder encrypted = new StringBuilder(message);
        CaesarCipherTwoKeys cipherTwoKeys = new CaesarCipherTwoKeys();
        cipherTwoKeys.setKeyEven(keyEven);
        cipherTwoKeys.setKeyOdd(keyOdd);
        cipherTwoKeys.setShiftedAlphabetEven(alphabet.substring(keyEven)
                + alphabet.substring(0, keyEven));
        cipherTwoKeys.setShiftedAlphabetOdd(alphabet.substring(keyOdd)
                + alphabet.substring(0, keyOdd));
        int currentIndex = 0;
        //!!!!!You want to compare the index of the for loop not the idx if it is odd! so save the currentIndex outside
        for (int i = 0; i < message.length(); i++) {
            char currChar = message.charAt(i);
            //Even
            if (currentIndex % 2 == 0) {
                int idx;
                if (Character.isLowerCase(currChar)) {
                    idx = alphabet.toLowerCase().indexOf(currChar);
                    if (idx != -1) {
                        char newChar = cipherTwoKeys.shiftedAlphabetEven.toLowerCase().charAt(idx);
                        encrypted.setCharAt(i, newChar);
                    }
                } else {
                    idx = alphabet.indexOf(currChar);
                    if (idx != -1) {
                        char newChar = cipherTwoKeys.shiftedAlphabetEven.charAt(idx);
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
                        char newChar = cipherTwoKeys.shiftedAlphabetOdd.toLowerCase().charAt(idx);
                        encrypted.setCharAt(i, newChar);
                    }
                } else {
                    idx = alphabet.indexOf(currChar);
                    if (idx != -1) {
                        char newChar = cipherTwoKeys.shiftedAlphabetOdd.charAt(idx);
                        encrypted.setCharAt(i, newChar);
                    }
                }
            }
            currentIndex++;
        }
        return encrypted.toString();
    }
}
