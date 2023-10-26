// start  from start=0. If currentFuel becomes -ve, it means we can't start from any point b/w starting point and i-1.In end return start.

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int c = 0, g = 0;
        int n = cost.length;
        for (int i = 0; i < n; i++) {
            c += cost[i];
            g += gas[i];
        }
        if (g < c)
            return -1;
        int currentGas = gas[0] - cost[0], start = 0;
        for (int i = 1; i < n; i++) {
            if (currentGas < 0) {
                start = i;
                currentGas = gas[i] - cost[i];
                continue;
            }
            currentGas = currentGas + gas[i] - cost[i];
        }
        return start;
    }
}