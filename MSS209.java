public class MSS209 {
    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int result = Integer.MAX_VALUE;
        // for (int i = 0; i < nums.length; i++) {
        // int sum = 0;
        // for (int j = i; j < nums.length; j++) {
        // sum += nums[j];
        // if (sum == target) {
        // result = Math.min(result, j - i + 1);
        // break;
        // }
        // if (sum > target) {
        // break;
        // }
        // }
        // }
        int st = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= target) {
                result = Math.min(result, end - st + 1);
                sum -= nums[st];
                st++;
            }
            end++;
        }
        if (result == Integer.MAX_VALUE)
            return 0;
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println(minSubArrayLen(11, arr));
    }
}