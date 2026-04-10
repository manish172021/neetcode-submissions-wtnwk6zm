class Solution {
    public int coinChange(int[] coins, int amount) {
        int memo[] = new int[amount + 1];
        Arrays.fill(memo, -1);
        int minCoins = coinChangeHelper(coins, amount, memo);
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }

    // 1, 2  20
    // , 20
    private int coinChangeHelper(int[] coins, int amount, int[] memo) {
        if(amount == 0) return 0;
        if(memo[amount] != -1) {
            return memo[amount];
        }
        int res = Integer.MAX_VALUE;
        for(int coin : coins) {
            if(amount - coin >= 0) {
                int smallAns = coinChangeHelper(coins, amount - coin, memo);
                if (smallAns != Integer.MAX_VALUE) {
                    res = Math.min(res, 1 + smallAns);
                }
            }
        }
        return memo[amount] = res;
    }
}
