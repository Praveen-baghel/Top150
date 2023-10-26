import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix54 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int lr = 0, rr = matrix.length - 1, lc = 0, rc = matrix[0].length - 1;
        int n = matrix.length, m = matrix[0].length;
        int size = n * m, counter = 0;
        while (lr <= rr && lc <= rc) {
            for (int i = lc; i <= rc; i++) {
                list.add(matrix[lr][i]);
                counter++;
            }
            lr++;
            if (counter == size)
                break;
            for (int i = lr; i <= rr; i++) {
                list.add(matrix[i][rc]);
                counter++;
            }
            rc--;
            for (int i = rc; i >= lc; i--) {
                list.add(matrix[rr][i]);
                counter++;
            }
            if (counter == size)
                break;
            rr--;
            for (int i = rr; i >= lr; i--) {
                list.add(matrix[i][lc]);
                counter++;
            }
            lc++;
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        System.out.println(spiralOrder(arr));
    }
}