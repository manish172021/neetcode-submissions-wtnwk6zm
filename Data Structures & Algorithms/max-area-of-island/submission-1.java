class Solution {

    int[][] XY_DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int ans = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j] && grid[i][j] == 1) {
                    ans = Math.max(ans, maxAreaOfIslandHelper(grid, i, j, m, n, visited));
                }
            }
        }
        return ans;
    }
    public int maxAreaOfIslandHelper(int[][] grid, int x, int y, int m, int n, boolean[][] visited) {
        Queue<int[]> pendingNode = new LinkedList<>();
        pendingNode.add(new int[]{x, y});
        visited[x][y] = true;
        int count = 0;
        while(!pendingNode.isEmpty()) {
            count++;
            int[] front = pendingNode.poll();
            for(int[] dir : XY_DIRS) {
                int dx = front[0] + dir[0];
                int dy = front[1] + dir[1];
                if(isValid(dx, dy, grid) && !visited[dx][dy] && grid[dx][dy] == 1) {
                    pendingNode.add(new int[]{dx, dy});
                    visited[dx][dy] = true;
                }
            }

        }
        return count;
    }


    private boolean isValid(int x, int y, int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] visited = new int[m][n];
        if(x >= 0 && y >=0 && x < m && y < n) {
            return true;
        }
        return false;
    }




}
