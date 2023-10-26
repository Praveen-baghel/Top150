import java.util.HashMap;
import java.util.Map;

public class WordPattern290 {
    public static boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        if (pattern.length() != arr.length)
            return false;
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if (map.containsKey(ch) && !map.get(ch).equals(arr[i])) {

                return false;
            } else if (!map.containsKey(ch) && map.values().contains(arr[i]))
                return false;
            else
                map.put(ch, arr[i]);

        }
        return true;

    }

    public static void main(String[] args) {
        String pattern = "abba", s = "dog cat cat fish";
        System.out.println(wordPattern(pattern, s));
    }
}
