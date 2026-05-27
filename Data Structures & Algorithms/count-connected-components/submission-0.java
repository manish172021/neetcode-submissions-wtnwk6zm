class Solution {
    public int countComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for(int i=0; i<n; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        boolean visited[] = new boolean[n];
        int ans = 0;

        for(int i=0; i<adjList.size(); i++) {
            if(!visited[i]) {
                ans++;
                bfs(adjList, i, visited);
            }
        }
        return ans;
    }

    private void bfs(ArrayList<ArrayList<Integer>> adjList, int sv, boolean[] visited) {
        Queue<Integer> pendingNode = new LinkedList<>();
        pendingNode.add(sv);
        visited[sv] = true;

        while(!pendingNode.isEmpty()) {
            int front = pendingNode.poll();

            for(int neighbor : adjList.get(front)) {
                if(!visited[neighbor]) {
                    pendingNode.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }

}
