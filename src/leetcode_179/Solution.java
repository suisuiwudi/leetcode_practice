package leetcode_179;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String largestNumber(int[] nums) {
        String[] numS = new String[nums.length];
        for (int i = 0; i < nums.length; i++){
            numS[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(numS,new Comparator<String>(){
            public int compare(String o1, String o2){
                return (o2+o1).compareTo(o1+o2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < numS.length; i++){
            sb.append(numS[i]);
        }
        int i = 0;
        while (i < sb.length() && sb.charAt(i) == '0' ) i++;
        sb.delete(0,i);
        if (sb.length() > 0)return sb.toString();
        else return "0";
    }
}