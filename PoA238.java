// take a left array to keep product of left elements to i, in same way taek a right array.In the end ,return left[i]*right[i].

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 1;
        right[n - 1] = 1;
        int product = 1;
        for (int i = 1; i < n; i++) {
            product = product * nums[i - 1];
            left[i] = product;
        }
        product = 1;
        for (int i = n - 2; i >= 0; i--) {
            product = product * nums[i + 1];
            right[i] = product;
        }
        for (int i = 0; i < n; i++) {
            nums[i] = left[i] * right[i];
        }
        return nums;
    }
}