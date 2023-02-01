package Quiz.second;

import java.util.Arrays;

public class Q2 {
    public static void main(String[] args) {
        String[] originalText = {"2second","5th","3third","4forth","1first"};
        String[] copiedText = originalText;
        Arrays.sort(copiedText);
        System.out.println(Arrays.toString(copiedText));
    }
}
