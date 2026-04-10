class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int stone : stones) pq.add(stone);
        
        while(pq.size() > 1) {
            int y = pq.poll();
            int x = pq.poll();
            if(y == x) continue;
            pq.add(y-x);
        }

        return pq.isEmpty() ? 0 : pq.poll();
    }
    // 6 4 3 2 2
    // 3 2 2 2
    // 2 2 1
    // 1
}
