package data;

import edu.duke.FileResource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
public class WordEdit {

    public static String reverseString(String word) {
        //if i wanted while loop i need to initialize before the loop the counter for the guard condition and the increment statement at the end of the loop!
        String reversed = "";

        for (int i = 0; i < word.length(); i++) {
            reversed = word.charAt(i) + word;
        }
        return reversed;
    }

    public static void charcterType() {

        String test = "abcdefghijklmnopqrstuvwxyz0123456789";
        String specialChar = "!@#%&*'+,-./:;<=>?]_`";

        for (int i = 0; i < test.length(); i++) {
            char character = test.charAt(i);
            if (Character.isDigit(character)) {
                System.out.println(character + " is a digit!");
            }
            if (Character.isAlphabetic(character)) {
                System.out.println(character + " is Aphabetical");
            }
            //if it contains even a Special character within then  it will return true!
            if (test.matches(specialChar)) {
                System.out.println(character + " contains atleast a Special Character!");
            }
        }
    }

    public static boolean isVowel(char ch) {

        boolean isVowel = false;
        String vowels = "aeiou";

        if (vowels.indexOf(ch) != -1 || vowels.toUpperCase().indexOf(ch) != -1) {

            isVowel = true;
        }
        return isVowel;
    }

    public static String replaceVowels(String word, char ch) {

        int currentIndex;

        //iteration loop
        for (int i = 0; i < word.length(); i++) {
            //current index
            currentIndex = i;
            // guard with condition
            if (isVowel(word.charAt(i))) {
                //the character to change in the one at the position of phrase at
                char charterToChange = word.charAt(currentIndex);
                //change the value with ch
                word.replace(charterToChange, ch);
                //remake the string to return it  as it is it replases only one char!
                word = word.replace(word.charAt(currentIndex), ch);
            }
        }
        return word;
    }

    public static String getStringEvenOrOddPart(String word, int starIndex) {

        String empty = " ";
        StringBuilder newMessage = new StringBuilder();

        if (starIndex % 2 == 0) {
            for (int i = 0; i < word.length(); i++) {
                if (i % 2 == 0) {

                    newMessage.append(word.charAt(i));
                    if (word.charAt(i) == empty.charAt(0)) {
                        newMessage.append(empty.charAt(0));
                    }
                }
            }
        } else {
            for (int i = 0; i < word.length(); i++) {
                if (i % 2 != 0) {
                    newMessage.append(word.charAt(i));
                    if (word.charAt(i) == empty.charAt(0)) {
                        newMessage.append(empty.charAt(0));
                    }
                }
            }
        }
        return newMessage.toString();
    }

    public static String emphasize(String word, char cha) {
        StringBuilder wordB = new StringBuilder(word);

        for (int i = 0; i < word.length(); i++) {
            //for Even chars
            if (i % 2 == 0) {
                if (word.charAt(i) == cha) {

                    wordB.setCharAt(i, '*');
                }

            } //for Odd chars
            else {
                if (word.charAt(i) == cha) {
                    wordB.setCharAt(i, '+');
                }
            }
        }
        return wordB.toString();
    }

    public static ArrayList<Character> getCharacterToArray(String word) {
        ArrayList<Character> populatedCharArray = new ArrayList<>();
        for (int i = 0; i < word.length() - 1; i++) {

            populatedCharArray.add(word.charAt(i));
        }
        return populatedCharArray;
    }
    public static char getCharFromWord(String word) {
        int index = word.length() - 1;
        return word.toCharArray()[index];

    }

    public static StringBuilder appendCharFromArray(ArrayList<Character> cha) {

        StringBuilder sum = new StringBuilder();
        for (int i = 0; i < cha.size() - 1; i++) {

            sum = sum.append(cha.get(i));

        }
        return sum;
    }

    public static ArrayList<String> getWordsFromFileToArrayTest() {
        FileResource resource = new FileResource("ReverseStringPalinDroms\\data\\errors.txt");
        ArrayList<String> wordsInFile = new ArrayList<>();
        int i = 0;
        for (String word : resource.words()) {
            wordsInFile.set(i, word);
            i++;
        }
        return wordsInFile;

    }

    public static ArrayList<String> getWordsFromFileToArray(FileResource resource) {

        ArrayList<String> wordsInFile = new ArrayList<>();

        for (String word : resource.words()) {
            wordsInFile.add(word);

        }
        return wordsInFile;

    }

    public static int indexOfWord(ArrayList<String> list, String word) {
        for (int k = 0; k < list.size(); k++) {

            if (list.get(k).equals(word)) {

                return k;
            }
        }
        return -1;
    }

    public static ArrayList<Integer> getCountOfCharacters(String word) {

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        ArrayList<Integer> counts = new ArrayList<Integer>(Collections.nCopies(26, 0));
        ArrayList<Character> countedCharcters = new ArrayList<>(word.length());
        Collections.fill(counts, 0);

        for (int i = 0; i < word.length(); i++) {
            char currentCharacter = word.charAt(i);
            //check if it was counted before!
            if (!Character.isLowerCase(currentCharacter)) {
                currentCharacter = Character.toLowerCase(currentCharacter);
            }
            //search for index of currentChar
            //if found count it!
            if (alphabet.indexOf(currentCharacter) != -1) {

                int currentIndexOfAlphabet = alphabet.indexOf(Character.toLowerCase(currentCharacter));
                //insert to counter array!
                counts.set(currentIndexOfAlphabet, counts.get(currentIndexOfAlphabet) + 1);
            } else {
                counts.add(1);
                countedCharcters.add(currentCharacter);
            }
        }
        return counts;
    }

    public static int getMaxIndex(ArrayList<Integer> array) {

        int currentMax = array.get(0);
        int maxIndex = 0;

        for (int i = 0; i < array.size(); i++) {

            if (currentMax < array.get(i)) {
                currentMax = array.get(i);
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static char getMostCommonCharFromWord(ArrayList<Integer> array) {

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        char mostCommonChar = ' ';
        int maxIndexChar = getMaxIndex(array);
        mostCommonChar = alphabet.charAt(maxIndexChar);
        return mostCommonChar;
    }

    public static ArrayList<String> getCommonWords() {
//C:\Users\Mircea\Documents\NetBeansProjects\JavaEEProjects\ReverseStringPalinDroms\data
//absolute C:\\Users\\Mircea\\Documents\\NetBeansProjects\\JavaEEProjects\\ReverseStringPalinDroms\\src\\reversestringpalindroms\\data\\common.txt
        FileResource resource = new FileResource("data\\common.txt");
        ArrayList<String> common = new ArrayList<>();
        int index = 0;

        for (String source : resource.words()) {
            common.set(index, source);
            index++;
        }
        return common;
    }

    public static void printCountedCommonWords(FileResource
                                                       resource, ArrayList<String> common, ArrayList<Integer> counts) {

        for (String word : resource.words()) {
            word = word.toLowerCase();
            int index = indexOfWord(common, word);
            if (index != -1) {
                counts.set(index, index++);
            }
        }
    }

    public static ArrayList<Integer> countCommonWordsToArray(FileResource
                                                                     resource, ArrayList<String> common, ArrayList<Integer> counts) {

        for (String word : resource.words()) {
            int i = 0;
            word = word.toLowerCase();
            counts.set(i, i++);
        }
        return counts;
    }

    public static void countCommonWordsInShakespeare() {
        //array intiliz
        ArrayList<String> plays = new ArrayList<>();
        plays.add("caesar.txt");
        plays.add("errors.txt");
        plays.add("hamlet.txt");
        plays.add("likeit.txt");
        plays.add("macbeth.txt");
        plays.add("romeo.txt");
        //plays.add("small.txt");
        ArrayList<String> common = getCommonWords();
        ArrayList<Integer> counts = new ArrayList<>();

        for (int k = 0; k < plays.size(); k++) {
            //absolute path C:\Users\Mircea\Documents\NetBeansProjects\JavaEEProjects\ReverseStringPalinDroms\
            //rootFolder\\data\\filename
            FileResource resource = new FileResource("ReverseStringPalinDroms\\data\\" + plays.get(k));
            countCommonWordsToArray(resource, common, counts);
            System.out.println("done with " + plays.get(k));
        }
        for (int k = 0; k < common.size(); k++) {
            System.out.println(common.get(k) + "\t" + counts.get(k));
        }
    }

    public static void alex(ArrayList<String> words) {
        //key,value
        HashMap<String, Integer> library = new HashMap<>();
        for (String word : words) {
            if (library.get(word) == null) {
                library.put(word, 1);
            } else {
                library.replace(word, library.get(word) + 1);
            }
        }
        for (String i : library.keySet()) {
            System.out.println("Key : " + i + " value : " + library.get(i));
        }
    }

    public static ArrayList<Integer> getCountList(ArrayList<String> words) {

        ArrayList<String> keys = new ArrayList<>();
        ArrayList<Integer> counts = new ArrayList<>();

        for (String word : words) {
            //if its null skip it!
            if (word != null) {

                int exists = getIndexOfElement(word, keys);
                if (exists != -1) {
                    counts.set(exists, counts.get(exists) + 1);
                } else {
                    keys.add(word);
                    counts.add(1);
                }
            }
        }
        return counts;
    }

    public static int getLenghtOfMostCommonWordInFile(FileResource file) {
        ArrayList<String> wordsInFile = getWordsFromFileToArray(file);
        ArrayList<Integer> countOfWordsInFile = getCountList(wordsInFile);
        int mostCommonIndex=getMaxIndex(countOfWordsInFile);
        String mostCommonWordInFile = wordsInFile.get(mostCommonIndex);
        int lenghtOfMostCommonWord =mostCommonWordInFile.length();
        return lenghtOfMostCommonWord;
    }

    public static int getIndexOfElement(String word, ArrayList<String> keys) {
        int i = 0;
        for (String element : keys) {

            if (word.equals(element)) {
                return i;
            } else {
                i++;
            }
        }
        return -1;
    }

    public static int getIndexOfCharacter(char value, ArrayList<Character> characters) {

        int i = 0;
        for (char letter : characters) {

            if (value == letter) {
                return i;

            } else {
                i++;

            }
        }
        return -1;
    }

    public static void countLengthOfWords(ArrayList<Integer> counts, ArrayList<String> words) {
        int i = 0;
        int count = 0;
        //check for special char at end of string and remove
        ArrayList<String> checkedWords = checkingWords(words);
        ArrayList<Integer> lengthsOfWords = new ArrayList<>();
        lengthsOfWords = getLengthFromWords(words);
        String currentWord = "";
        //iterations of words
        for (i = 0; i < checkedWords.size() - 1; i++) {
            //int of word
            currentWord = checkedWords.get(i);
            int lengthOfCurrentWord = currentWord.length();
        }
        for (int j = 0; j < counts.size(); j++) {
            //number of repetions  // number of counted emelents ... complete fail!
            System.out.println("The words is : " + checkedWords.get(j) + " with size : " + lengthsOfWords.get(j) +
                    " are it's counts are  : " + counts.get(j));
        }
    }

    public static ArrayList<String> checkingWords(ArrayList<String> words) {
        ArrayList<String> checkedWords = new ArrayList<>();
        String currentWord = "";

        for (int i = 0; i < words.size() - 1; i++) {
            currentWord = words.get(i);
            char currentElement = getCharFromWord(currentWord);
            //add it to new arralist
            //check at the end of the word
            if (i == words.size() - 1) {
                //if the char is letter ok else! return new array!
                if (!Character.isLetter(currentElement)) {
                    return checkedWords;
                }
            }
            checkedWords.add(String.valueOf(currentWord));
        }
        return checkedWords;
    }


    public static ArrayList<Integer> getLengthFromWords(ArrayList<String> words) {
        int i = 0;
        String currenWord = "'";
        ArrayList<Integer> lengthOfWords = new ArrayList<>();
        for (i = 0; i < words.size() - 1; i++) {
            currenWord = words.get(i);
            int currentLength = currenWord.length();
            lengthOfWords.add(currentLength);
        }
        return lengthOfWords;
    }
}




