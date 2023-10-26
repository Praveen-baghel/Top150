import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class InsertInterval57 {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            int[][] result = new int[1][2];
            result[0][0] = newInterval[0];
            result[0][1] = newInterval[1];
            return result;
        }
        int[][] result = new int[intervals.length + 1][intervals[0].length];
        for (int j = 0; j < intervals.length; j++) {
            for (int k = 0; k < intervals[0].length; k++) {
                result[j][k] = intervals[j][k];
            }
        }
        result[result.length - 1][0] = newInterval[0];
        result[result.length - 1][1] = newInterval[1];
        Arrays.sort(result, Comparator.comparingInt(a -> a[0]));

        List<int[]> merged = new ArrayList<>();
        int[] currentInterval = result[0];

        for (int i = 1; i < result.length; i++) {
            if (currentInterval[1] >= result[i][0]) {
                currentInterval[1] = Math.max(currentInterval[1], result[i][1]);
            } else {
                merged.add(currentInterval);
                currentInterval = result[i];
            }
        }

        merged.add(currentInterval);

        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] arr = {};
        int[] newInterval = { 2, 5 };
        int[][] result = insert(arr, newInterval);
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }
}
