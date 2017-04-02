package leetcode_435;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval o1, Interval o2){
                return o1.end - o2.end;
            } 
        });
        int n = intervals.length;
        int p = -Integer.MAX_VALUE;
        int num = 0;
        for (int i = 0 ; i < n; i++){
            if (intervals[i].start >= p){
                p = intervals[i].end;
                num++;
            }
        }
        return n - num;
    }
}