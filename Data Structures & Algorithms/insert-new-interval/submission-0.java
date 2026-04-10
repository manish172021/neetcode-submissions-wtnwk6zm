class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int index = bs(intervals, newInterval[0]);
        List<int[]> res = new ArrayList<>();
        for(int i=0; i<index; i++) {
            res.add(intervals[i]);
        }
        res.add(newInterval);
        for(int i=index; i<intervals.length; i++) {
            res.add(intervals[i]);
        }

        return mergeIntevals(res);

    }

    private int bs(int[][] intervals, int k) {
        int left = 0, right = intervals.length-1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(intervals[mid][0] < k) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return left;
    }

    private int[][] mergeIntevals(List<int[]> intervals) {
        List<int[]> ans = new ArrayList<>();
        int lastElement = -1;
        for(int[] interval : intervals) {
            if(ans.isEmpty() || ans.get(ans.size() - 1)[1] < interval[0]) {
                ans.add(interval);
            }
            else {
                ans.get(ans.size() - 1)[1] = Math.max(
                    ans.get(ans.size() - 1)[1],
                    interval[1]
                ); 
            }
        }
        return ans.toArray(new int[0][]);
    }
}
