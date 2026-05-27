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
    // Time  = O(n² log n) || Space = O(n²)
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


    // Time  = O(n²) || Space = O(n)
    public int minCostConnectPointsOpt(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];

        // weight[i] = minimum cost needed to connect node i into MST
        int[] weight = new int[n];
        Arrays.fill(weight, Integer.MAX_VALUE);

        weight[0] = 0;
        int mstCost = 0;

        for(int i = 0; i < n; i++) {
            int minVertex = findMinVertex(weight, visited);
            visited[minVertex] = true;

            mstCost += weight[minVertex];

            // Update minimum distance for remaining nodes
            for(int nextNode = 0; nextNode < n; nextNode++) {
                if(!visited[nextNode]) {
                    int newDist =
                        Math.abs(points[minVertex][0] - points[nextNode][0]) +
                        Math.abs(points[minVertex][1] - points[nextNode][1]);

                    weight[nextNode] = Math.min(weight[nextNode], newDist);
                }
            }
        }

        return mstCost;
    }

    private int findMinVertex(int[] weight, boolean[] visited) {
        int minVertex = -1;
        for(int i = 0; i < weight.length; i++) {
            if(!visited[i] && (minVertex == -1 || weight[i] < weight[minVertex])) {
                minVertex = i;
            }
        }
        return minVertex;
    }

}
