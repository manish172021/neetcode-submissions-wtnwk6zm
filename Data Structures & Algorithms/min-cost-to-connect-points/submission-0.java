class Solution {
    /*
    0 -> [0,0]
    1 -> [2,2]
    2 -> [3,3]
    3 -> [2,4]
    4 -> [4,2]


    (0,1) = |0-2| + |0-2| = 4
    (0,2) = |0-3| + |0-3| = 6
    (0,3) = |0-2| + |0-4| = 6
    (0,4) = |0-4| + |0-2| = 6

    (1,2) = |2-3| + |2-3| = 2
    (1,3) = |2-2| + |2-4| = 2
    (1,4) = |2-4| + |2-2| = 2

    (2,3) = |3-2| + |3-4| = 2
    (2,4) = |3-4| + |3-2| = 2

    (3,4) = |2-4| + |4-2| = 4 


    [
        [0,1,4],
        [0,2,6],
        [0,3,6],
        [0,4,6],

        [1,2,2],
        [1,3,2],
        [1,4,2],

        [2,3,2],
        [2,4,2],

        [3,4,4]
    ]

    */

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        List<int[]> edges = new ArrayList<>();

        // Build complete graph
        // edge = {u, v, weight}

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int wt = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[]{i, j, wt});
            }
        }
        return kruskalMST(n, edges);
    }

    private int kruskalMST(int V, List<int[]> edges) {
        Collections.sort(edges, (a, b) -> a[2] - b[2]);
        int[] parent = new int[V];
        for(int i = 0; i < V; i++) {
            parent[i] = i;
        }

        int mstCost = 0;
        int edgesUsed = 0;

        for(int[] edge : edges) {
            int u = edge[0], v = edge[1], wt = edge[2];

            int sourceParent = findParent(u, parent);
            int destParent = findParent(v, parent);

            if(sourceParent != destParent) {
                mstCost += wt;
                // Union
                parent[sourceParent] = destParent;
                edgesUsed++;
                // MST completed
                if(edgesUsed == V - 1) {
                    break;
                }
            }
        }

        return mstCost;
    }

    private int findParent(int node, int[] parent) {
        if(parent[node] == node) {
            return node;
        }
        // Path compression
        return parent[node] = findParent(parent[node], parent);
    }
}
