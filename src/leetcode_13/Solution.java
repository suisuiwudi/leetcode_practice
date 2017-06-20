package leetcode_13;

public class Solution {
    public int romanToInt(String s) {
        StringBuilder sb = new StringBuilder(s);
        int lastIndex = 0;
        int num = 0;
        String[] roman = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] number = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        while (lastIndex != s.length()){
            for (int i = 0; i < roman.length; i++){
                if (lastIndex+roman[i].length() <= s.length() && sb.substring(lastIndex,lastIndex+roman[i].length()).equals(roman[i])){
                    num+=number[i];
                    lastIndex += roman[i].length();
                    break;
                }
            }
        }
        return num;
    }
}