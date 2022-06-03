public class Simple {
    private static String word;
    private static String phrase;
    public Simple(int number, String w) {
        word = w;
        phrase = mystery(number, w);
    }
    private static String mystery(int num, String s) {
        String answer = "";
        for (int k=0; k<num; k++) {
            answer = answer + s;
        }
        return answer;
    }

    public String toString() {
        return phrase + " is " + word + " repeated";
    }
}
