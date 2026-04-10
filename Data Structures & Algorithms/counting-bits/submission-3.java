class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        int offset = 1;

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i / 2] + (i % 2);
            // even number → last bit = 0 → same as i/2  
            // odd number  → last bit = 1 → +1 from i/2
            // or dp[i] = dp[i >> 1] + (i & 1);
        }
        return dp;
    }
}
