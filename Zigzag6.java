 class Solution {
    public static String convert(String s, int numRows) {
        StringBuilder result = new StringBuilder("");
        int n = s.length() - 1;
        int start, mid, end;
        for (int i = 0; i < numRows; i++) {
            start = i;
            while (true) {
                result.append(s.charAt(start));
                if (i == 0 || i == numRows - 1) {
                    end = start + (2 * numRows - 2);
                    if (end > n) {
                        break;
                    }
                    start = end;
                    continue;
                }
                mid = start + (2 * numRows - 2) - 2 * i;
                if (mid > n) {
                    break;
                }
                result.append(s.charAt(mid));
                end = start + (2 * numRows - 2);
                if (end > n) {
                    break;
                }
                start = end;
            }
        }
        return result.toString();
    }
}




 /* ChatGpt
import java.util.ArrayList;
import java.util.List;

class Solution {
    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s; // No change for a single row
        }

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        int currentRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(currentRow).append(c);
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }
            currentRow += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}
*/