class Solution {

    public int[] twoSum(int[] numbers, int target) {
        int start = 0, end = numbers.length - 1;
        
        while (start < end) {
            int sum = numbers[start] + numbers[end];
            
            if (sum == target) {
                // Found the numbers that sum up to the target, return their indices.
                return new int[]{start + 1, end + 1};
            } else if (sum < target) {
                start++;
            } else {
                end--;
            }
        }
        
        // Return an empty array if no solution is found.
        return new int[0];
    }
}
