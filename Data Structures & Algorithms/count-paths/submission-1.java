class Solution {
    
    public int uniquePaths(int m, int n) {
        int memo[][] = new int[m+1][n+1];
        for(int i=0; i<m+1; i++) {
            Arrays.fill(memo[i], -1);
        }
        return uniquePaths(m, n, memo);
    }

    public int uniquePaths(int m, int n, int memo[][]) {
        if(m < 1 || n < 1) return 0;
        if(m == 1 || n == 1) return 1;
        if(memo[m][n] != -1) return memo[m][n];

        return memo[m][n] = uniquePaths(m-1, n, memo) + uniquePaths(m, n-1, memo);
    }
}
