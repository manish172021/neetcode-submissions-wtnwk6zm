class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGasAccumlated = 0;
        int totalGasSpent = 0;
        for(int i=0; i<gas.length; i++) {
            totalGasAccumlated += gas[i];
            totalGasSpent += cost[i];
        }
        if(totalGasAccumlated < totalGasSpent) return -1;

        int total = 0;
        int potentialIndex = 0;
        for(int i=0; i<gas.length; i++) {
            total += gas[i] - cost[i];
            if(total < 0) {
                potentialIndex = i + 1;
                total = 0;
            }
        }
        return potentialIndex;

    }

    private int travel(int start, int[] gas, int[] cost) {
       int tank = 0;
       int i = start;
       boolean first = false;
       while(i != start || !first) {
        first = true;
        tank = tank + gas[i];
        int gasNeeded = cost[i];
        if(tank < gasNeeded) {
            return -1;
        }
        tank -= cost[i];
        i = (i + 1) % gas.length;
       }
       return start;
    }
}
