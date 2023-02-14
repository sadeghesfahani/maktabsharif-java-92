package HW2;

import java.util.Arrays;
import java.util.Scanner;

public class first {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(permute(new Scanner(System.in).nextLine())));
    }

    private static char[] swap(char[] args) {
        char temp;
        temp = args[0];
        args[0] = args[1];
        args[1] = temp;
        return args;
    }

    private static String[] permute(String args) {
        if (args.length() == 3) {
            String[] allPermutes = new String[6];
            int index = 0;
            char[] characters = args.toCharArray();
            for (int i = 0; i < args.length(); i++) {
                char[] characterStartedWithI = getCharacterListStartsWith(i, characters);
                allPermutes[index++] = String.valueOf(characterStartedWithI[0]) + characterStartedWithI[1] + characterStartedWithI[2];
                char[] swapped = swap(new char[]{characterStartedWithI[1], characterStartedWithI[2]});
                allPermutes[index++] = String.valueOf(characterStartedWithI[0]) + swapped[0] + swapped[1];
            }
            return allPermutes;
        }
        return new String[]{"does", "not", "supported"};
    }

    private static char[] getCharacterListStartsWith(int startAtIndex, char[] list) {
        char[] temp = new char[list.length];
        temp[0] = list[startAtIndex];
        int index = 1;
        for (int i = 0; i < list.length; i++) {
            if (i != startAtIndex) {
                temp[index++] = list[i];
            }
        }
        return temp;
    }
}
