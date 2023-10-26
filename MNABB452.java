import java.util.*;

public class MNABB452 {
    public static int findMinArrowShots(int[][] points) {
        if (points.length == 1) {
            return 1;
        }
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int[] currentInterval = points[0];
        int counter = 0;
        for (int i = 1; i < points.length; i++) {
            if (currentInterval[1] >= points[i][0]) {
                currentInterval[0] = Math.max(currentInterval[0], points[i][0]);
                currentInterval[1] = Math.min(currentInterval[1], points[i][1]);
            } else {
                counter++;
                currentInterval = points[i];
            }
        }
        counter++;
        return counter;

    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 2 }, { 3, 4 }, { 5, 6 }, { 7, 8 } };
        System.out.println(findMinArrowShots(arr));
    }
}