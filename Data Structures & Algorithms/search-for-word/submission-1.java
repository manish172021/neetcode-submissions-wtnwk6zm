class Solution {

    private static int[][] XY_DIR = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    // DFS + Backtracking, not BFS
    // BFS mixes multiple paths together.
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if (!visited[i][j] && board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j, 0, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


     private boolean dfs(char[][] board, String word, int x, int y, int idx, boolean[][] visited) {
        if (idx == word.length()) {
            return true;
        }
        if (!isValid(board, x, y)) {
            return false;
        }
        // Already visited
        // OR character mismatch
        if (isValid(board, x, y) && visited[x][y] || board[x][y] != word.charAt(idx)) {
            return false;
        }

        visited[x][y] = true;

        for (int[] d : XY_DIR) {
            int nx = x + d[0];
            int ny = y + d[1];
            if (dfs(board, word, nx, ny, idx + 1, visited)) {
                return true;
            }
        }
        visited[x][y] = false; // Unmark for future paths
        return false;
    }

    private boolean isValid(char board[][], int x, int y) {
        int m = board.length, n = board[0].length;
        return x >= 0 && y >= 0 && x < m && y < n;
    }
}






    