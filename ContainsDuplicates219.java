import java.util.*;

public class ContainsDuplicates219 {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;

    }

    public static void main(String[] args) {
        int[] arr = { 1, 0, 1, 1 };
        System.out.println(containsNearbyDuplicate(arr, 1));
    }
}