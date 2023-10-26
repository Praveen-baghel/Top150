import java.util.ArrayList;
import java.util.List;

public class TextJustification68 {

  public static String correct(StringBuilder str, int maxWidth) {
    boolean flag = false;
    String s = str.toString().trim();
    List<Character> list = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      list.add(s.charAt(i));
    }
    while (list.size() != maxWidth) {
      int i = 0;
      while (i < list.size()) {
        if (i == list.size() - 1 && !flag) {
          list.add(' ');
          flag = true;
        }
        if (list.get(i) == ' ') {
          list.add(i, ' ');
          while (i < list.size() - 1 && list.get(i) == ' ') i++;
          flag = true;
        }
        if (list.size() == maxWidth) {
          break;
        }
        i++;
      }
    }
    StringBuilder result = new StringBuilder("");
    for (char item : list) {
      result.append(item);
    }
    return result.toString();
  }

  public static List<String> fullJustify(String[] words, int maxWidth) {
    List<String> result = new ArrayList<>();
    StringBuilder str = new StringBuilder("");
    for (String word : words) {
      if (str.length() + word.length() > maxWidth) {
        result.add(correct(str, maxWidth));
        str.setLength(0);
        str.append(word + " ");
        continue;
      } else if (str.length() + word.length() == maxWidth) {
        str.append(word);
        result.add(str.toString());
        str.setLength(0);
        continue;
      }
      str.append(word + " ");
    }
    if (str.length() != 0) {
      while (str.length() != maxWidth) {
        str.append(' ');
      }
      result.add(str.toString());
    }

    return result;
  }

  public static void main(String[] args) {
    String[] arr = {
      "Here",
      "is",
      "an",
      "example",
      "of",
      "text",
      "justification.",
    };
    System.out.println(fullJustify(arr, 14));
  }
}
