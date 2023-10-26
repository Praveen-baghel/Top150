import java.util.*;

public class IsomorphicString205 {

    public static boolean solve(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        char sChar, tChar;
        for (int i = 0; i < s.length(); i++) {
            sChar = s.charAt(i);
            tChar = t.charAt(i);
            if (map.containsKey(sChar) && map.get(sChar) != tChar) {
                return false;
            } else if (!map.containsKey(sChar) && map.values().contains(tChar)) {
                return false;
            } else {
                map.put(sChar, tChar);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "baa", t = "aaa";
        System.out.println(solve(s, t));
    }
}