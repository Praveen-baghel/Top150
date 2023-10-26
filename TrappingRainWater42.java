class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0 || n == 1) {
            return 0;
        }
        int result = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        int lMax = height[0];
        int rMax = height[n - 1];
        left[0] = 0;
        right[n - 1] = 0;
        for (int i = 1; i < n; i++) {
            lMax = Math.max(lMax, height[i - 1]);
            left[i] = lMax;
            rMax = Math.max(rMax, height[n - i]);
            right[n - i - 1] = rMax;
        }
        for (int i = 0; i < n; i++) {
            int h = Math.min(left[i], right[i]);
            if (h > height[i]) {
                result += (h - height[i]);
            }
        }
        return result;
    }
}