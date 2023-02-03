package CW2;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Q2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        // you are students of maktab sharif , maktab maktab
        String[] arrayOfText = text.split(" ");
        // ["you", "are", "studetns",...]
        // ["maktab", "maktab"]
        String[] repeatedTexts = new String[arrayOfText.length / 2];

        // ["maktab", "sharif","maktab", "sharif","maktab", "sharif"]
        int index = 0;
        for (int i = 0; i < arrayOfText.length; i++) {
            for (int j = i + 1; j < arrayOfText.length; j++) {
                if (Objects.equals(arrayOfText[i], arrayOfText[j])) {
                    boolean isRepeated = false;
                    for (int k = 0; k < repeatedTexts.length; k++) {
                        if (Objects.equals(repeatedTexts[k], arrayOfText[i])) {
                            isRepeated = true;
                        }
                    }
                    if (isRepeated == false) {
                        repeatedTexts[index++] = arrayOfText[i];
                    }

                }
            }
        }
        // repeatedTexts = ["maktab",'sharif',null]
        int valueAbleDataIndex = 0;
        for (int i = 0; i < repeatedTexts.length; i++) {
            if (repeatedTexts[i] != null) {
                valueAbleDataIndex++;
            } else {
                break;
            }
        }
        // ["maktab","sharif"]
        String[] finalRepeatedTexts = new String[valueAbleDataIndex];
        for (int i = 0; i < valueAbleDataIndex; i++) {
            finalRepeatedTexts[i]=repeatedTexts[i];
        }
        System.out.println(Arrays.deepToString(finalRepeatedTexts));
    }

}
