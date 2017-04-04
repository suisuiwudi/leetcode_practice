package leetcode_56;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Definition for an interval. public class Interval { int start; int end;
 * Interval() { start = 0; end = 0; } Interval(int s, int e) { start = s; end =
 * e; } }
 */
public class Solution {
	public List<Interval> merge(List<Interval> intervals) {
		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});
		List<Interval> ans = new ArrayList();
		Interval pre = new Interval(-Integer.MAX_VALUE, -Integer.MAX_VALUE);
		boolean firstFlag = false;
		for (Interval interval : intervals) {
			if (interval.start > pre.end) {
				if (!firstFlag)
					firstFlag = true;
				else
					ans.add(pre);
				pre = interval;
			} else {
				if (interval.end > pre.end)
					pre = new Interval(pre.start, interval.end);
			}
		}
		if (firstFlag)
			ans.add(pre);
		return ans;
	}
}