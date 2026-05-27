class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        int[] parent = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for(int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            int parentU = findParent(u, parent);
            int parentV = findParent(v, parent);

            // cycle detected
            if(parentU == parentV) {
                return edge;
            }

            parent[parentU] = parentV;
        }

        return new int[0];
    }

    private int findParent(int node, int[] parent) {

        if(parent[node] == node) {
            return node;
        }

        // path compression
        return parent[node] = findParent(parent[node], parent);
    }
}
