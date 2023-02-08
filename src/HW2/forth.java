package HW2;


import java.util.Arrays;
import java.util.Scanner;

public class forth {
    private static int turn = 1; // amir = 1, ali = 2
    private static Scanner console = new Scanner(System.in);
    private static int[][] map;

    public static void main(String[] args) {
        int column = 3;
        int row = 3;
        map = new int[row][column];
        boolean isGameFinished = false;
        String winner = "";
        while (!isGameFinished) {
            System.out.println(getWhoIsHisTurnName() + " turn, enter column number:");
            int inputColumn = console.nextInt();
            fillColumn(inputColumn);
            drawMap();
            GameResult result = checkWinner();
            if(result.isGameFinished){
                isGameFinished = true;
                winner = result.winner;
            }

        }
        if(!winner.equals("")){
            System.out.println("winner: " + winner);
        }else{
            System.out.println("it's a tie.");
        }

    }

    private static String getWhoIsHisTurnName() {
        if (turn == 1) {
            return "amir";
        }
        return "ali";
    }

    private static void fillColumn(int column) {
        boolean affectedAny = false;
        if (validateInput(column)) {
            for (int i = map.length - 1; i >= 0; i--) {
                if (map[i][column - 1] == 0) {
                    map[i][column - 1] = turn;
                    affectedAny = true;
                    break;
                }
            }
            if (!affectedAny) {
                System.out.println("column is full. try another one.");
            } else {
                changeTurn();
            }
        } else {
            System.out.println("Column out of range, try again.");
        }

    }

    private static boolean validateInput(int column) {
        return map[0].length >= column;
    }

    private static void changeTurn() {
        if (turn == 1) {
            turn = 2;
        } else {
            turn = 1;
        }
    }

    private static void drawMap() {
        for (int row = 0; row < map.length; row++) {
            for (int column = 0; column < map[0].length; column++) {
                System.out.print(" " + getRepresentativeOfTurn(map[row][column]) + " ");
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }

    private static String getRepresentativeOfTurn(int turn) {
        if (turn == 1) {
            return "*";
        } else if (turn == 2) {
            return "0";
        }
        return " ";

    }

    private static GameResult checkWinner() {

        return new GameResult(true, "amir");
    }


}

class GameResult {
    public boolean isGameFinished = false;
    public String winner = "";

    public GameResult(boolean isGameFinished, String winner) {
        this.isGameFinished = isGameFinished;
        this.winner = winner;
    }
}
