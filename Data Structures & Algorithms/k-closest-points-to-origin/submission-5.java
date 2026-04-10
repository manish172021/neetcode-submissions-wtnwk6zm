class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> Double.compare(p1.value, p2.value));
        for(int i=0; i<points.length; i++) {
            pq.add(new Pair(i, getDisFromOrigin(points[i])));
            System.out.println("key " + pq.peek().index + " value " + pq.peek().value);
        }
        int count = 0;
        while(count != k) {
            res[count++] = points[pq.poll().index];
        }

        return res;
    }

    private double getDisFromOrigin(int[] point) {
        double x = Math.pow((double) point[0] - 0, 2.0);
        double y = Math.pow((double) point[1] - 0, 2.0);
        return Math.sqrt(x + y);
    }

    class Pair {
        int index;
        double value;

        Pair(int index, double value) {
            this.index = index;
            this.value = value;
        }
    }
}
