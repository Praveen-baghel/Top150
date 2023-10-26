import java.util.*;

public class SimplifPath71 {
    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        int c = 0;
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '/')
                c++;
            else
                break;
        }
        String[] arr = path.substring(c).split("/+");
        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case ".":
                    break;
                case "..":
                    if (!stack.isEmpty())
                        stack.pop();
                    break;
                default:
                    stack.push(arr[i]);
            }
        }
        List<String> list = new ArrayList<>(stack);
        // Collections.reverse(list);
        StringBuilder result = new StringBuilder("/");
        for (int i = 0; i < list.size(); i++) {
            result.append((i == list.size() - 1) ? list.get(i) : list.get(i) + "/");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "/home/../clear/.//jj/..../";
        System.out.println(simplifyPath(s));
    }
}