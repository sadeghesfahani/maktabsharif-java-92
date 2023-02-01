package HW1;

import java.util.Scanner;

public class Main {
    protected static Factory factory = new Factory();
    public static boolean isStillRunning = true;

    public static void main(String[] args) {
        int[][] listOfNumbers = new int[2][4];

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

class Console {
    public static Scanner get = new Scanner(System.in);
}



