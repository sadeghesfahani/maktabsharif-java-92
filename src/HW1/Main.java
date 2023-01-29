package HW1;

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
        switch (command){
            case "first":
                return new First();
            case "second":
                return new Second();

        }
        return null;
    }
}

interface Command {
    void execute() ;
}


class First implements Command {
    protected int rate;

    @Override
    public void execute() {
        System.out.print("Please enter your salary income: ");
        int income = Console.get.nextInt();
        if(income<0){
            System.out.println("wrong salary");
        }else{
            if(income < 3_000_000){
                rate = 5;
            }else if(income < 6_000_000){
                rate = 10;
            }else {
                rate = 24;
            }
            System.out.println("Net income will be: "+ ((double) income * (1 - (double) rate/100)) + "$");
        }

    }
}


class Second implements Command{

    @Override
    public void execute() {

    }
}
class Console {
    public static Scanner get = new Scanner(System.in);
}
