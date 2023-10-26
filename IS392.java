class Solution {
    public boolean isSubsequence(String s, String t) {
        if (t.length() < s.length())
            return false;
        int n1 = s.length(), n2 = t.length();
        int counter = 0;
        int p1 = 0, p2 = 0;
        while (p1 < n1 && p2 < n2) {
            if (s.charAt(p1) == t.charAt(p2)) {
                counter++;
                p1++;
                p2++;
            } else {
                p2++;
            }
        }
        if (counter == n1)
            return true;
        return false;
    }
}