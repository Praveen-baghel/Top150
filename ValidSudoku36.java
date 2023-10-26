class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        Set<String> seen = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char currentVal = board[i][j];
                if (currentVal != '.') {
                    // Check rows, columns, and 3x3 grids
                    if (!seen.add(currentVal + " in row " + i) ||
                            !seen.add(currentVal + " in column " + j) ||
                            !seen.add(currentVal + " in grid " + i / 3 + "-" + j / 3)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
