package HW2;

import java.util.Scanner;

public class forth {
    private static int turn = 1; // amir = 1, ali = 2
    private static Scanner console = new Scanner(System.in);
    private static int[][] map;

    public static void main(String[] args) {
        int column = 4;
        int row = 4;
        map = new int[row][column];
        boolean isGameFinished = false;
        String winner = "";
        while (!isGameFinished) {
            System.out.println(getWhoIsHisTurnName() + " turn, enter column number:");
            int inputColumn = console.nextInt();
            fillColumn(inputColumn);
            drawMap();
            GameResult result = checkWinner();
            if (result.isGameFinished) {
                isGameFinished = true;
                winner = result.winner;
            }

        }
        if (!winner.equals("")) {
            System.out.println("winner: " + winner);
        } else {
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
        String winner = "";
        winner = getWinner(winner, map);
        if (winner.equals("")) {
            int[][] traversed = reverseMap();
            winner = getWinner(winner, traversed);
        }

        if (winner.equals("")) {
            winner = checkDiameter();
        }

        return new GameResult(!winner.equals(""), winner);

    }

    private static String getWinner(String winner, int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            int firstCountRow = 0;
            int secondCountRow = 0;
            for (int column = 0; column < matrix[row].length; column++) {
                if (matrix[row][column] == 1) {
                    firstCountRow++;
                } else if (matrix[row][column] == 2) {
                    secondCountRow++;
                }
            }
            if (firstCountRow >= 4) {
                winner = "amir";
            } else if (secondCountRow >= 4) {
                winner = "ali";
            }
        }
        return winner;
    }

    private static int[][] reverseMap() {
        int[][] traversedMatrix = new int[map[0].length][map.length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                traversedMatrix[i][j] = map[j][i];
            }
        }
        return traversedMatrix;
    }

    private static String checkDiameter() {
        return extractPotentialWinnerFromMatrix(map);
    }

    private static String extractPotentialWinnerFromMatrix(int[][] matrix) {
        int firstCounterOriginal = 0;
        int firstCounterOther = 0;
        int secondCounterOriginal = 0;
        int secondCounterOther = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                if (row == column) {
                    if (matrix[row][column] == 1) {
                        firstCounterOriginal++;
                    } else if (matrix[row][column] == 2) {
                        secondCounterOriginal++;
                    }
                }
            }

        }
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                if (row + column == matrix.length - 1) {
                    if (matrix[row][column] == 1) {
                        firstCounterOther++;
                    } else if (matrix[row][column] == 2) {
                        secondCounterOther++;
                    }
                }
            }
        }
        if (firstCounterOriginal >= 4 || firstCounterOther >= 4) {
            return "amir";
        } else if (secondCounterOriginal >= 4 || secondCounterOther >= 4) {
            return "ali";
        }
        return "";
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
