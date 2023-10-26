// max answer would be n and min would be zero. Use binary search to find the correct between this range. If found, search in second half
// because we have to maximize the answer.

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int min = 0, max = n;
        while (min < max) {
            int mid = (min + max + 1) / 2;
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (citations[i] >= mid) {
                    count++;
                }
            }
            if (count >= mid) {
                min = mid;
            } else {
                max = mid - 1;
            }
        }
        return min;
    }
}