class Solution {


    public int eraseOverlapIntervals(int[][] intervals) {
        // return eraseOverlapIntervalsRec(intervals);
        // return eraseOverlapIntervalsMemo(intervals);
        return eraseOverlapIntervalsMemoBS(intervals);
    }

        

    // 2^n
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

    // n^2
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

        // n*logn
    private int eraseOverlapIntervalsMemoBS(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[][] memo = new int[intervals.length][intervals.length + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        int maxKeep = helperBS(intervals, 0, -1, memo);
        return intervals.length - maxKeep;
    }

    private int helperBS(int[][] intervals, int idx, int prev, int[][] memo) {
        if (idx == intervals.length) {
            return 0;
        }
        if(memo[idx][prev + 1] != -1) return memo[idx][prev + 1];

        // // skip current interval
        int exclude = helper(intervals, idx + 1, prev, memo);
        // take current interval
        int nextIdx = binarySearch(intervals, intervals[idx][1]);
        
        int include = 0;
        if (prev == -1 || intervals[prev][1] <= intervals[idx][0]) {
            include = 1 + helper(intervals, nextIdx, idx, memo);
        }

        return memo[idx][prev + 1] = Math.max(include, exclude);
    }

    private int binarySearch(int[][] intervals, int k) {
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
}
