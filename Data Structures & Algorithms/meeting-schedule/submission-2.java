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
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        int prev = -1;
        for(Interval interval: intervals) {
            if(prev == -1 || prev <= interval.start) {
                prev = interval.end;
            }
            else {
                return false;
            }
        }
        return true;
    }
}
