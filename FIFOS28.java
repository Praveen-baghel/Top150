class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }
        int n = needle.length();
        for (int i = 0; i < haystack.length(); i++) {
            if(i+n>haystack.length()){
                return -1;
            }
            if (haystack.substring(i, i + n).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}

/* Shortcut
    class Solution{
        public int strStr(String haystack, String needle){
            return haystack.indexOf(needle);
        }
    }

 */