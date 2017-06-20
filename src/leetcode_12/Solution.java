package leetcode_12;

public class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        String[] roman = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] number = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        while (num!=0){
            for (int i = 0; i < roman.length; i++){
                if (num >= number[i]){
                    sb.append(roman[i]);
                    num-=number[i];
                    break;
                }
            }
        }
        return sb.toString();
    }
}