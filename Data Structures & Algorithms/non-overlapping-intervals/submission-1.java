class Solution {


    public int eraseOverlapIntervals(int[][] intervals) {
        // return eraseOverlapIntervalsRec(intervals);
        return eraseOverlapIntervalsMemo(intervals);
    }

        


    private int eraseOverlapIntervalsRec(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int maxKeep = helper(intervals, 0, -1);
        return intervals.length - maxKeep;
    }

    private int helper(int[][] intervals, int idx, int prev) {
        if (idx == intervals.length) {
            return 0;
        }
        int exclude = helper(intervals, idx + 1, prev);
        int include = 0;
        if (prev == -1 || intervals[prev][1] <= intervals[idx][0]) {
            include = 1 + helper(intervals, idx + 1, idx);
        }

        return Math.max(include, exclude);
    }

    private int eraseOverlapIntervalsMemo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[][] memo = new int[intervals.length][intervals.length + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        int maxKeep = helper(intervals, 0, -1, memo);
        return intervals.length - maxKeep;
    }

    private int helper(int[][] intervals, int idx, int prev, int[][] memo) {
        if (idx == intervals.length) {
            return 0;
        }
        if(memo[idx][prev + 1] != -1) return memo[idx][prev + 1];

        int exclude = helper(intervals, idx + 1, prev, memo);
        int include = 0;
        if (prev == -1 || intervals[prev][1] <= intervals[idx][0]) {
            include = 1 + helper(intervals, idx + 1, idx, memo);
        }

        return memo[idx][prev + 1] = Math.max(include, exclude);
    }
}
