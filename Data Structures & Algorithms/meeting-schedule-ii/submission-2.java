/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int max = 0;
        int range[] = new int[1000001];

        for(Interval interval : intervals) {
            range[interval.start]++;
            range[interval.end]--;
        }

        int maxPrefixSum = 0;
        int prevSum = 0;
        for(int r : range) {
            prevSum += r;
            maxPrefixSum = Math.max(prevSum, maxPrefixSum);
        }
        return maxPrefixSum;



        // 0 5 10 15 20 40
        // 1 1 -1  1 -1  -1
        // 1 2  1  2  1   0


    }
}
