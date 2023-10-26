// traverse from left to right , then right to left and then store the max between them

class Solution {
    public int candy(int[] ratings) {
        int result = 0;
        int n = ratings.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            left[i] = 1;
            right[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            result += Math.max(left[i], right[i]);
        }
        return result;
    }
}