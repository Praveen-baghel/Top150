import java.util.*;

public class SCAW30 {
    public static List<Integer> findSubstring(String s, String[] words) {
        int sl = s.length();
        int wl = words[0].length();
        int nw = words.length;
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i <= sl - wl * nw; i++) {
            String str = s.substring(i, i + wl * nw);
            HashMap<String, Integer> map2 = new HashMap<>();
            for (int j = 0; j <= str.length() - wl; j += wl) {
                String temp = str.substring(j, j + wl);
                map2.put(temp, map2.getOrDefault(temp, 0) + 1);
            }
            if (map.equals(map2))
                list.add(i);
        }
        return list;

    }

    public static void main(String[] args) {
        String str = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
        String[] words = { "fooo", "barr", "wing", "ding", "wing" };
        System.out.println(findSubstring(str, words));
    }
}