import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int answer = 0;
        int left, right, currentMax;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                left = map.getOrDefault(num - 1, 0);
                right = map.getOrDefault(num + 1, 0);
                currentMax = left + right + 1;
                map.put(num, currentMax);
                answer = Math.max(answer, currentMax);
                map.put(num - left, currentMax);
                map.put(num + right, currentMax);
            }
        }

        return answer;
    }
}