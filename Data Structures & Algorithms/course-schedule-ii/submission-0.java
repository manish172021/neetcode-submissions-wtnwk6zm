class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        // b -> a
        for(int[] prerequisite : prerequisites) {
            adjList.get(prerequisite[1]).add(prerequisite[0]);
        }

        return bfsDetectcycle(numCourses, adjList);
    }

    public int[] bfsDetectcycle(int v, ArrayList<ArrayList<Integer>> adjList) {
        int[] indegree = new int[v];
        List<Integer> topoOrder = new ArrayList<>();

        for(ArrayList<Integer> list : adjList) {
            for(int val : list) {
                indegree[val]++;
            }
        }
  
        Queue<Integer> pendingNode = new LinkedList<>();
        
        for(int i= 0; i<v; i++) {
            if(indegree[i] == 0) {
                pendingNode.add(i);
            }
        }


        int count = 0;

        while(!pendingNode.isEmpty()) {
            int front = pendingNode.poll();
            topoOrder.add(front);
            count++;

            for(int neighbour : adjList.get(front)) {
                indegree[neighbour]--;
                if(indegree[neighbour] == 0) {
                    pendingNode.add(neighbour);
                }
            }
        }

        return count == v
                ? topoOrder.stream().mapToInt(i -> i).toArray()
                : new int[0];
    }
}
