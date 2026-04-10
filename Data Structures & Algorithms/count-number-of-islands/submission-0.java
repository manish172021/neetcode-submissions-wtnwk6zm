class Solution {

    private static int[][] XY_DIR = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};


    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean visited[][] = new boolean[m][n];
        int ans = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j] && grid[i][j] == '1') {
                    ans++;
                    numIslandsHelper(i, j, m, n, grid, visited);
                }
            }
        }
        return ans;
    }

    private void numIslandsHelper(int x, int y, int m, int n, char[][] grid, boolean[][] visited) {
        Queue<int[]> pendingNode = new LinkedList<>();
        pendingNode.add(new int[] {x, y});
        visited[x][y] = true;

        while(!pendingNode.isEmpty()) {
            int[] front = pendingNode.poll();

            for(int[] dir : XY_DIR) {
                int nx = front[0] + dir[0];
                int ny = front[1] + dir[1];

                if(isValid(grid, nx, ny) && !visited[nx][ny] && grid[nx][ny] == '1') {
                    pendingNode.add(new int[] {nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }



    private boolean isValid(char grid[][], int x, int y) {
        int m = grid.length, n = grid[0].length;
        return x >= 0 && y >= 0 && x < m && y < n;
    }
}
