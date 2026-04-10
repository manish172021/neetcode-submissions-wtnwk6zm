class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int memo[] = new int[cost.length];
        Arrays.fill(memo, -1);
        return Math.min(minCostClimbingStairs(cost, 0, memo), minCostClimbingStairs(cost, 1, memo));
    }

    private int minCostClimbingStairs(int[] cost, int start, int memo[]) {
        if(start >= cost.length) return 0;
        if(memo[start] != -1) return memo[start];
        int op1 = minCostClimbingStairs(cost, start + 1, memo);
        int op2 = minCostClimbingStairs(cost, start + 2, memo);
        return memo[start] = cost[start] + Math.min(op1, op2);
    }
}
