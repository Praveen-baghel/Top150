import java.util.HashSet;
import java.util.Set;

public class LSWRC3 {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 1 || s.length() == 0)
            return s.length();
        int cMax = 0, result = 0, index;
        char ch;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (!set.contains(ch)) {
                set.add(ch);
                cMax++;
                result = Math.max(cMax, result);
            } else {
                index = s.substring(0, i).lastIndexOf(ch);
                for (int j = i - cMax; j < index; j++) {
                    set.remove(s.charAt(j));
                }
                cMax = i - index;
                result = Math.max(cMax, result);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "tmmzuxt";
        System.out.println(lengthOfLongestSubstring(s));
    }
}

/*
 * ChatGpt
 * 
 * import java.util.HashMap;
 * 
 * public class LSWRC3 {
 * public static int lengthOfLongestSubstring(String s) {
 * int n = s.length();
 * int maxLength = 0;
 * HashMap<Character, Integer> charIndexMap = new HashMap<>();
 * 
 * for (int start = 0, end = 0; end < n; end++) {
 * char currentChar = s.charAt(end);
 * if (charIndexMap.containsKey(currentChar)) {
 * start = Math.max(charIndexMap.get(currentChar) + 1, start);
 * }
 * maxLength = Math.max(maxLength, end - start + 1);
 * charIndexMap.put(currentChar, end);
 * }
 * 
 * return maxLength;
 * }
 * 
 * public static void main(String[] args) {
 * String s = "tmmzuxt";
 * System.out.println(lengthOfLongestSubstring(s));
 * }
 * }
 * 
 */