package HW2;

import java.util.Arrays;

public class second {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] traversedMatrix = new int[3][3];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                traversedMatrix[i][j] = matrix[j][i];
            }
        }
        System.out.println(Arrays.deepToString(traversedMatrix));
    }
}
