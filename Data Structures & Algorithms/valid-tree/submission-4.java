class Solution {

    // Time:  O(E * α(V)) // α(V) = inverse Ackermann function; almost constant so O(E)
    // Space: O(V + E)
    public boolean validTree(int n, int[][] edges) {
        // A graph is tree only if:

        // 1. No cycle
        // 2. edges = n - 1
        // 3. Fully connected (If graph has n-1 edges and no cycle, it can only have exactly one connected component.)

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for(int i=0; i<n; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            adjList.get(edge[1]).add(edge[0]);
            adjList.get(edge[0]).add(edge[1]);
        }

        // necessary condition
        if(edges.length != n - 1) {
            return false;
        }

        return !detectCyclyeUD(n, adjList);
    }

    private boolean detectCyclyeUD(int V, ArrayList<ArrayList<Integer>> adjList) {
        int[] parent = new int[V];

        for(int i=0; i<V; i++) {
            parent[i] = i;
        }

        for(int u = 0; u < V; u++) {
            for(int v : adjList.get(u)) {
                if(u < v) {
                    int sourceParent = findParent(u, parent);
                    int destParent = findParent(v, parent);

                    if(sourceParent == destParent) {
                        return true;
                    }

                    parent[sourceParent] = destParent;
                }
            }
        }
        return false;
    }

    private int findParent(int node, int[] parent) {
        if(parent[node] == node) {
            return node;
        }
        // path compression
        return parent[node] = findParent(parent[node], parent);
    }
}