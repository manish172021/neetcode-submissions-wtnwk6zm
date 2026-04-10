class Solution {
    public int change(int amount, int[] coins) {
        int[][] memo = new int[amount+1][coins.length];
        for(int[] temp : memo) Arrays.fill(temp, -1);
        return change(amount, coins, 0, memo);
        
    }

    private int change(int amount, int[] coins, int idx, int[][] memo) {
        if(amount == 0) return 1;
        if(amount < 0) return 0;
        if(idx > coins.length - 1) return 0;
        if(memo[amount][idx] != -1) {
            return memo[amount][idx];
        }
        int op1 = change(amount, coins, idx + 1, memo);
        int op2 = change(amount - coins[idx], coins, idx, memo);
        return memo[amount][idx] = op1 + op2;
    }
}
