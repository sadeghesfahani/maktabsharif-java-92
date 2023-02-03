package CW2.friday;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q1 {
    public static void main(String[] args) {
        int[] listOfNumbers = {1,2,3,4,5,6,7,8,1,23,426,7,2345,36,3,2234,5,7647,23,542,64,362,423,53,46};
        Set<Integer> notRepeated = new HashSet<>();
        for (int number : listOfNumbers) {
            notRepeated.add(number);
        }
        int[] notRepeatedList = new int[notRepeated.size()];
        int index = 0;
        for (int number:
             notRepeated) {
            notRepeatedList[index++] = number;
        }
        int[] decSortedList = new int[notRepeatedList.length];

        int sortedIndex = 0;
        while(sortedIndex != decSortedList.length - 1){
            int min = notRepeatedList[0];
            for (int i = 0; i < decSortedList.length; i++) {
                if(min> notRepeatedList[i] ){
                    boolean isInSortedList = false;
                    for (int j = 0; j < decSortedList.length; j++) {
                        if(decSortedList[j] == notRepeatedList[i]){
                            isInSortedList =true;
                        }
                    }
                    if(!isInSortedList){
                        min = notRepeatedList[i];
                    }

                }

            }
            decSortedList[sortedIndex] = min;
            int[] newSortedList = new int[notRepeatedList.length-1];
            for (int i = 1; i < notRepeatedList.length; i++) {
                newSortedList[i-1] = notRepeatedList[i];
            }
            notRepeatedList = newSortedList;
            sortedIndex++;
        }

        System.out.println(Arrays.toString(decSortedList));
//        for (int i = 0; i < notRepeatedList.length; i++) {
//            notRepeatedList[i]=notRepeated.;
//        }

    }
}
