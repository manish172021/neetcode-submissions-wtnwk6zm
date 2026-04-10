class Solution {

    int[][] XY_DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int INF = 2147483647;

    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == INF) {
                    grid[i][j] = bfs(grid, i, j);
                }
            }
        }

    }

    private int bfs(int[][] grid, int sx, int sy) {
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        Queue<int[]> pendingNode = new LinkedList<>();
        pendingNode.add(new int[]{sx, sy, 0});
        visited[sx][sy] = true;

        while(!pendingNode.isEmpty()) {
            
            int[] front = pendingNode.poll();
            int cx = front[0], cy = front[1], steps = front[2];
            if(grid[cx][cy] == 0) {
                return steps;
            }
            for(int dir[] : XY_DIRS) {
                int nx = cx + dir[0];
                int ny = cy + dir[1];

                if(isValid(grid, nx, ny) && !visited[nx][ny] && grid[nx][ny] != -1) {
                    pendingNode.add(new int[]{nx, ny, steps + 1});
                    visited[nx][ny] = true;
                }
            }
        }
        return INF;
    }


    private boolean isValid(int[][] grid, int x, int y) {
        if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) return true;
        return false;
    }
}
