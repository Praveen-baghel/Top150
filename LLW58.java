class Solution {
    public int lengthOfLastWord(String s) {
        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ' && result > 0) {
                break;
            } else if (s.charAt(i) == ' ') {
                continue;
            }
            result++;
        }
        return result;
    }
}