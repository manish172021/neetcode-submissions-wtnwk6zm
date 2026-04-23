class CountSquares {
    private Map<List<Integer>, Integer> ptsCount;

    public CountSquares() {
        ptsCount = new HashMap<>();
    }
    
    public void add(int[] point) {
        List<Integer> p = Arrays.asList(point[0], point[1]);
        ptsCount.put(p, ptsCount.getOrDefault(p, 0) + 1);
    }
    
// x, py       px, py

// dx, dy        px, y

    public int count(int[] point) {
        int ans = 0;
        int qx = point[0], qy = point[1];
        for(Map.Entry<List<Integer>, Integer> entry: ptsCount.entrySet()) {
            List<Integer> dPoint = entry.getKey();
            int dx = dPoint.get(0);
            int dy = dPoint.get(1);
            // Only consider diagonal points of square
            if (dx == qx || dy == qy || Math.abs(dx - qx) != Math.abs(dy - qy)) {
                continue;
            }
            List<Integer> p1 = Arrays.asList(dx, qy);
            List<Integer> p2 = Arrays.asList(qx, dy);
            if(ptsCount.containsKey(p1) && ptsCount.containsKey(p2)) {
                ans += (ptsCount.get(p1) * ptsCount.get(p2) * ptsCount.get(dPoint));
            }
        }
        return ans;
    }
}
