class Solution {

    int[][] XY_DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int orangesRotting(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int maxTime = bfs(grid, visited);
        for(int x=0; x<grid.length; x++) {
            for(int y=0; y<grid[0].length; y++) {
                if(grid[x][y] == 1) {
                    return -1;
                }
            }
        }
        return maxTime;
    }

    private int bfs(int[][] grid, boolean[][] visited) {
        int maxTime = 0;
        Queue<int[]> pendingNode = new LinkedList<>();
        for(int x=0; x<grid.length; x++) {
            for(int y=0; y<grid[0].length; y++) {
                if(grid[x][y] == 2) {
                    // visited[x][y] = true;
                    pendingNode.add(new int[]{x, y, 0});
                }
            }
        }

        while(!pendingNode.isEmpty()) {
            int[] front = pendingNode.poll();
            for(int[] dir : XY_DIRS) {
                int nx = front[0] + dir[0];
                int ny = front[1] + dir[1];
                int nt = front[2];
                if(isValid(nx, ny, grid) && grid[nx][ny] == 1) {
                    // visited[nx][ny] = true;
                    pendingNode.add(new int[]{nx, ny, nt + 1});
                    maxTime = Math.max(maxTime, nt + 1);
                    grid[nx][ny] = 2;
                }
            }
        }
        return maxTime;
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
