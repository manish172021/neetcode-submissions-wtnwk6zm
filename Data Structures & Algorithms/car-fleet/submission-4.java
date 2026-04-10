class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<int[]> ps = new ArrayList<>();
        for(int i=0; i<position.length; i++) {
            ps.add(new int[]{position[i], speed[i]});
        }
        Collections.sort(ps, (a, b) -> b[0] - a[0]);
        Stack<Double> s = new Stack<>();
        for(int[] t : ps) {
            double time = (double)(target - t[0])/t[1];
            System.out.println(time);
            if(s.isEmpty() || s.peek() < time) {
                s.push(time);
            }
        }
        return s.size();

    //    position = [7, 4, 1, 0]
    //    speed =    [1, 2, 2, 1]
    //    time       [3, 3, 4.5 10]



    //    position = [7, 5, 3, 1]
    //    speed =    [1, 2, 17, 0.5] 20
    //    time       [13, 7.5, 1, 38, 8, 14, 7]

    //    13 38 



    }
}
