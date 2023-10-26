import java.util.Arrays;

public class GameOfLife289 {
    public static void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] temp = new int[m + 2][n + 2];
        for (int i = 0; i < m + 2; i++) {
            temp[i][0] = 0;
            temp[i][n + 2 - 1] = 0;
        }
        for (int i = 0; i < n + 2; i++) {
            temp[0][i] = 0;
            temp[m + 2 - 1][i] = 0;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                temp[i][j] = board[i - 1][j - 1];
            }
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                int count = temp[i - 1][j - 1] + temp[i - 1][j] + temp[i - 1][j + 1] + temp[i][j - 1]
                        + temp[i][j + 1] + temp[i + 1][j - 1] + temp[i + 1][j] + temp[i + 1][j + 1];
                if (temp[i][j] == 1) {
                    if (count < 2) {
                        board[i-1][j-1] = 0;
                    } else if (count == 2 || count == 3) {
                        board[i-1][j-1] = 1;
                    } else if (count > 3) {
                        board[i-1][j-1] = 0;
                    }
                } else {
                    if (count == 3) {
                        board[i-1][j-1] = 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };
        gameOfLife(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}