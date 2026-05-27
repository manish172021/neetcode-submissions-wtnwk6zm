class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();

        for(int i=0; i<=n; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int[] time : times) {
            int u = time[0];
            int v = time[1];
            int wt = time[2];
            // directed edge
            adjList.get(u).add(new int[]{v, wt});
        }

        int[] distance = dijkstra(n, adjList, k);
        
        int maxTime = 0;

        for(int i = 1; i <= n; i++) {
            // unreachable node
            if(distance[i] == Integer.MAX_VALUE) {
                return -1;
            }
            maxTime = Math.max(maxTime, distance[i]);
        }

        return maxTime;
        
    }

    // T((V + E) log V) = O(E log V)  || S(V + E)
    public int[] dijkstra(int V, ArrayList<ArrayList<int[]>> adjList, int source) {

        int[] distance = new int[V + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        // {node, distance}
        PriorityQueue<int[]> pendingNode = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pendingNode.add(new int[]{source, 0});

        while(!pendingNode.isEmpty()) {

            int[] front = pendingNode.poll(); //  Get node having minimum current distance

            int node = front[0];
            int dist = front[1];

            // Ignore outdated queue entry.
            // A shorter path to this node was already found earlier.
            if(dist > distance[node]) {
                continue;
            }

            for(int[] neighbour : adjList.get(node)) {

                int nextNode = neighbour[0];
                int wt = neighbour[1];

                int newDist = dist + wt;

                // Relaxation:
                // If going through current node gives shorter path,
                // update shortest distance
                if(newDist < distance[nextNode]) {
                    distance[nextNode] = newDist;
                    pendingNode.add(new int[]{nextNode, newDist});
                }
            }
        }

        return distance;
    }
}
