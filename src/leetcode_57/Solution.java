package leetcode_57;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import data_structure.Interval;

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
    private TreeMap<Integer, Interval> map;
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        map = new TreeMap();
        for (Interval interval : intervals){
            map.put(interval.start,interval);
        }
        Integer lowerKey;
        if (map.containsKey(newInterval.start)) 
            lowerKey = newInterval.start;
        else 
            lowerKey = map.lowerKey(newInterval.start);
        if (lowerKey != null && newInterval.start <= map.get(lowerKey).end){
            newInterval.start = Math.min(map.get(lowerKey).start, newInterval.start); 
            newInterval.end = Math.max(map.get(lowerKey).end, newInterval.end);
            map.remove(lowerKey);
        }
        Integer higherKey = map.higherKey(newInterval.start);
        while (higherKey!=null && newInterval.end >= map.get(higherKey).start){
            newInterval.start = Math.min(map.get(higherKey).start, newInterval.start); 
             newInterval.end = Math.max(map.get(higherKey).end, newInterval.end);
            map.remove(higherKey);
            higherKey = map.higherKey(newInterval.start);
        }
        map.put(newInterval.start, newInterval);
        return new ArrayList(map.values());
    }
}