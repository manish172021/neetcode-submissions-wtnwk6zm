class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i=0; i<gas.length; i++) {
            if(travel(i, gas, cost) != -1) {
                return i;
            }
        }
        return -1;
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
