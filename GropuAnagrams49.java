import java.util.*;

public class GropuAnagrams49 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String newStr = String.valueOf(arr);
            if (!map.containsKey(newStr)) {
                map.put(newStr, new ArrayList<>());
                map.get(newStr).add(strs[i]);
            } else {
                map.get(newStr).add(strs[i]);
            }
        }
        for (List<String> item : map.values()) {
            result.add(item);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        for (List<String> list : groupAnagrams(strs)) {
            System.out.println(list);
        }
    }
}
