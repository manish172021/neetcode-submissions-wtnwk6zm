class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];
        // dist, x, y
        PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> Integer.compare(a1[0], a2[0]));
        for(int i=0; i<points.length; i++) {
            pq.add(new int[]{getDisFromOrigin(points[i]), points[i][0], points[i][1]});
        }
        int count = 0;
        while(count != k) {
            int[] point = pq.poll();
            res[count++] = new int[]{point[1], point[2]};
        }

        return res;
    }

    private int getDisFromOrigin(int[] point) {
        int x = point[0] * point[0];
        int y = point[1] * point[1];
        return x+y;
    }

    
}
