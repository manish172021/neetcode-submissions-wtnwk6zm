class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for(int i=0; i<numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int[] prerequisite : prerequisites) {
            adjList.get(prerequisite[1]).add(prerequisite[0]);
        }

        return !bfsDetectcycle(numCourses, adjList);
    }

    //   ->    
    // 0    1
    //   <-

    // 1 -> 1 0 -> 1


    // 0 -> 1, 2, 3
    // 1 -> 0

    public boolean bfsDetectcycle(int v, ArrayList<ArrayList<Integer>> adjList) {
        int[] indegree = new int[v];

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
            count++;

            for(int neighbour : adjList.get(front)) {
                indegree[neighbour]--;
                if(indegree[neighbour] == 0) {
                    pendingNode.add(neighbour);
                }
            }
        }

        return v != count;


    }
}
