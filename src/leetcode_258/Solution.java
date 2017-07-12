package leetcode_258;

public class Solution {
    public int addDigits(int num) {
        return 1 + (num - 1) % 9;
    }
}