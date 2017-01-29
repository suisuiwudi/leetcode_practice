package leetcode_495;

public class Solution {
	public int findPosisonedDuration(int[] timeSeries, int duration) {
		int ans = 0;
		int i;
		for (i = 0; i < timeSeries.length - 1; i++) {
			ans += Math.min(timeSeries[i + 1] - timeSeries[i], duration);
		}
		if (i == timeSeries.length - 1)
			ans += duration;
		return ans;
	}
}