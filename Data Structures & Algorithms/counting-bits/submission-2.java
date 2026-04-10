class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        int offset = 1;

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i / 2] + (i % 2);
            // Right shift → divide by 2
            // (i & 1) → check last bit
        }
        return dp;
    }
}
