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

        }
        return null;
    }
}

interface Command {
    void execute() ;
}


class First implements Command {

    @Override
    public void execute() {

    }
}

class Console {
    public static Scanner get = new Scanner(System.in);
}
