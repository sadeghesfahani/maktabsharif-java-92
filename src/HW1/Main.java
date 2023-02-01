package HW1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    protected static Factory factory = new Factory();
    public static boolean isStillRunning = true;

    public static void main(String[] args) {
        while (isStillRunning) {
            System.out.print("Please select what HW you want to run? (exit for close) ");
            String command = Console.get.next();
            Command process = factory.getCommand(command);
            process.execute();
        }
    }

}

class Factory {
    public Command getCommand(String command) {
        switch (command) {
            case "first":
                return new First();
            case "second":
                return new Second();
            case "third":
                return new Third();
            case "forth":
                return new Forth();  // I'm pretty sure the algorithm I used is awful, didn't want to look it up.
            case "fifth":
                return new Fifth();
        }
        return null;
    }
}

interface Command {
    void execute();
}


class First implements Command {
    protected int rate;

    @Override
    public void execute() {
        System.out.print("Please enter your salary income: ");
        int income = Console.get.nextInt();
        if (income < 0) {
            System.out.println("wrong salary");
        } else {
            if (income < 3_000_000) {
                rate = 5;
            } else if (income < 6_000_000) {
                rate = 10;
            } else {
                rate = 24;
            }
            System.out.println("Net income will be: " + ((double) income * (1 - (double) rate / 100)) + "$");
        }

    }
}


class Second implements Command {

    @Override
    public void execute() {
        System.out.println("which one do you wanna use? stack(1) or reversed for(2)? ");
        int questionType = Console.get.nextInt();
        System.out.println("enter your desire text: ");
        if (questionType == 1) {
            stack();
        } else {
            reversedFor();
        }
    }

    private void stack() {
        String targetText = Console.get.next();
        Stack stack = new Stack(targetText);
        System.out.println(stack.reverse());
    }

    private void reversedFor() {
        String targetText = Console.get.next();
        String reversedText = "";
        for (int i = 0; i < targetText.length(); i++) {
            reversedText = reversedText.concat(Character.toString(targetText.charAt(targetText.length() - 1 - i)));
        }
        System.out.println(reversedText);
    }
}


class Stack {
    private String[] listOfItems;

    private int index = 0;

    public Stack(String text) {
        listOfItems = new String[text.length()];
        for (int i = 0; i < listOfItems.length; i++) {
            push(Character.toString(text.charAt(i)));
        }
    }


    public String reverse() {
        String textStream = "";
        for (int i = 0; i < listOfItems.length; i++) {
            textStream += pop();
        }
        return textStream;
    }


    private void push(String item) {
        if (index < listOfItems.length) {
            listOfItems[index++] = item;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private String pop() {
        return listOfItems[--index];
    }


}


class Third implements Command {

    @Override
    public void execute() {
        System.out.println("Enter number of pyramid line: ");
        int lines = Console.get.nextInt();

        for (int i = 0; i <= lines; ++i) {
            for (int space = 1; space <= lines - i; ++space) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println(" ");
        }


    }
}


class Forth implements Command {
    private int[] series;

    @Override
    public void execute() {
        System.out.println("How many numbers you will enter? ");
        int numberOfItems = Console.get.nextInt();
        series = new int[numberOfItems];
        System.out.println("Enter numbers: ");
        for (int i = 0; i < numberOfItems; i++) {
            series[i] = Console.get.nextInt();
        }
        System.out.println("Incremental info:");
        findIncremental();
        System.out.println("Decremental info:");
        findDecremental();

    }

    private void findIncremental() {
        int[][] allIncrementalSeries = new int[series.length][series.length]; // for the case we need them
        boolean[][] representativeBooleanList = new boolean[series.length][series.length];
        int outerIndex = 0;
        int innerIndex = 0;
        int min = series[0];
        for (int i = 0; i < series.length; i++) {
            if (min <= series[i]) {
                allIncrementalSeries[outerIndex][innerIndex] = series[i];
                representativeBooleanList[outerIndex][innerIndex] = true;
                innerIndex++;
                min = series[i];
            } else {
                min = series[i];
                outerIndex++;
                innerIndex = 0;
                allIncrementalSeries[outerIndex][innerIndex] = series[i];
                representativeBooleanList[outerIndex][innerIndex] = true;
                innerIndex++;
            }
        }
        findMaxLengthAndNumber(representativeBooleanList);
    }

    private void findDecremental() {
        int[][] allDecrementalSeries = new int[series.length][series.length]; // for the case we need them
        boolean[][] representativeBooleanList = new boolean[series.length][series.length];
        int outerIndex = 0;
        int innerIndex = 0;
        int max = series[0];
        for (int i = 0; i < series.length; i++) {
            if (max >= series[i]) {
                allDecrementalSeries[outerIndex][innerIndex] = series[i];
                representativeBooleanList[outerIndex][innerIndex] = true;
                innerIndex++;
                max = series[i];
            } else {
                max = series[i];
                outerIndex++;
                innerIndex = 0;
                allDecrementalSeries[outerIndex][innerIndex] = series[i];
                representativeBooleanList[outerIndex][innerIndex] = true;
                innerIndex++;
            }
        }
        findMaxLengthAndNumber(representativeBooleanList);
    }

    private void findMaxLengthAndNumber(boolean[][] representativeBooleanList) {
        int numberOfIncrementalSeries = 0;
        int biggestNumber = 0;
        for (int i = 0; i < representativeBooleanList.length; i++) {
            int tempCounter = 0;
            for (int j = 0; j < representativeBooleanList[i].length; j++) {
                if (representativeBooleanList[i][j]) {
                    tempCounter++;
                } else {
                    break;
                }
            }
            if (tempCounter > 1) {

                numberOfIncrementalSeries++;
                if (tempCounter > biggestNumber) {
                    biggestNumber = tempCounter;
                }
            }
        }
        System.out.println("maxlength of subsequence: " + biggestNumber);
        System.out.println("number of subsequence: " + numberOfIncrementalSeries);
    }

}


class Fifth implements Command {

    private ExpandableList expandableList = new ExpandableList();
    private boolean stillRunning = true;

    @Override
    public void execute() {
        System.out.println("Enter as much number as you want, when finished, type exit:");
        while (stillRunning) {
            String input = Console.get.next();
            if (input.equals("exit")) {
                stillRunning = false; // it could have been implemented with while true and break, this way feels better
            } else {
                expandableList.push(Integer.parseInt(input));
            }
        }
        findDifferentiate();

    }

    private void findDifferentiate() {
        int[] finalList = expandableList.getListItem(); // it could have been used directly, but it might be used several time in a real world application. so, I explicitly destructured it to avoid CPU hit as much as possible.
        int max = finalList[0];
        int min = finalList[0];

        for (int i = 0; i < finalList.length; i++) {

            if(finalList[i]>max){
                max = finalList[i];
            }
            if(finalList[i]<min){
                min=finalList[i];
            }

        }
        int maxDifferentiate = max - min;
        int minDifferentiate = maxDifferentiate;
        for (int i = 0; i < finalList.length; i++) {
            for (int j = 0; j < finalList.length; j++) {
                if (i != j) {
                    int def = Math.abs(finalList[i] - finalList[j]);
                    if(def<minDifferentiate){
                        minDifferentiate = def;
                    }

                }
            }
        }

        System.out.println("Max differentiate: " + maxDifferentiate);
        System.out.println("min differentiate: " + minDifferentiate);

    }
}


class ExpandableList {
    private int[] listItem = new int[2];
    private int index = 0;

    public void push(int item) {
        if (index > listItem.length - 1) {
            int[] newListItem = new int[listItem.length * 2];
            for (int i = 0; i < listItem.length; i++) {
                newListItem[i] = listItem[i];
            }
            listItem = newListItem;
        }
        listItem[index++] = item;
    }

    public int[] getListItem() {
        return listItem;
    }
}

class Console {
    public static Scanner get = new Scanner(System.in);

}



