import java.util.HashMap;
import java.util.Map;

public class MWS76 {
    public static String minWindow(String s, String t) {
        String result = "";
        int n1 = s.length(), n2 = t.length();
        if (n1 < n2) {
            return "";
        }
        int j = 0;
        int k = n2;
        while (k <= n1) {
            if (isValid(s.substring(j, k), t)) {
                String s1 = s.substring(j, k);
                while (isValid(s1, t)) {
                    if (result.length() == 0) {
                        result = s1;
                    } else {
                        result = result.length() < s1.length() ? result : s1;
                    }
                    j++;
                    s1 = s.substring(j, k);
                }
                k++;
            } else {
                k++;
            }
        }
        return result;

    }

    private static boolean isValid(String s, String t) {
        if (t.length() > s.length())
            return false;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }
        for (char ch : map2.keySet()) {
            if (map1.containsKey(ch)) {
                if (map1.get(ch) < map2.get(ch))
                    return false;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
}

/* ChatGpt
import java.util.HashMap;
import java.util.Map;

public class MWS76 {
    public static String solve(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int minLeft = 0, minLength = Integer.MAX_VALUE, count = 0, left = 0;
        for (int right = 0; right < n1; right++) {
            char ch = s.charAt(right);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) >= 0) {
                    count++;
                }
            }
            while (count == n2) {
                if (minLength > right - left + 1) {
                    minLength = right - left + 1;
                    minLeft = left;
                }
                char temp = s.charAt(left);
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);
                    if (map.get(temp) > 0) {
                        count--;
                    }
                }
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLength);
    }

    public static void main(String[] args) {
        System.out.println(solve("ADOBECODEBANC", "ABC"));
    }
}
 */