package leetcode_134;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumG[] = new int[gas.length * 2 + 1];
        int sumC[] = new int[cost.length * 2 + 1];
        sumG[0] = 0;
        sumC[0] = 0;
        for (int i = 1; i < gas.length * 2 + 1; i++){
            sumG[i] = sumG[i-1] + gas[(i-1) % gas.length];
            sumC[i] = sumC[i-1] + cost[(i-1) % cost.length];
        }
        int i = 0;
        int j = 0;
        while (j - i < gas.length && j < gas.length*2){
            j++;
            while (sumG[j] - sumG[i] < sumC[j] - sumC[i]) i++;
        }
        if (j - i == gas.length) return i;
        else return -1;
    }
}