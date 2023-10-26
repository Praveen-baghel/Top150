class Solution {

  private static boolean isValid(char ch) {
    return (
      ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z' || ch >= '0' && ch <= '9'
    );
  }

  public boolean isPalindrome(String s) {
    if (s.length() == 0 || s.length() == 1) {
      return true;
    }
    int n = s.length();
    s = s.toLowerCase();
    int st = 0, en = n - 1;
    while (st < en) {
      if (isValid(s.charAt(st)) && isValid(s.charAt(en))) {
        if (s.charAt(st) != s.charAt(en)) {
          return false;
        }
        st++;
        en--;
      }
      if (!isValid(s.charAt(st))) st++;
      if (!isValid(s.charAt(en))) en--;
    }
    return true;
  }
}
