import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> answer = new ArrayList<>();
        if (n == 0) {
            return answer;
        }
        if (n == 1) {
            answer.add(String.valueOf(nums[0]));
            return answer;
        }
        int s = 0, e = 1;
        while (s < n && e < n) {
            if (nums[e] == nums[e-1] + 1) {
                e++;
            } else {
                if (s == e - 1) {
                    answer.add(String.valueOf(nums[s]));
                } else {
                    answer.add(String.valueOf(nums[s]) + "->" + String.valueOf(nums[e - 1]));
                }
                s = e;
                e++;
            }
        }
        if (s == e - 1) {
            answer.add(String.valueOf(nums[s]));
        } else {
            answer.add(String.valueOf(nums[s]) + "->" + String.valueOf(nums[e - 1]));
        }
        return answer;

    }
}