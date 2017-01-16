/*
 * this class is to test some recent cases I am dealing with 
 * and it will always change 
 * if you want to look at the performance 
 * go to leetcode website and submit the code in other folder or make main() yourself 
 */

import leetcode_321.*;
public class main_test {

    public static void main(String[] args) {
    	long a=System.currentTimeMillis();
    	Solution solution = new Solution();
    	int[] num1={6,7};
    	int[] num2={6,0,4};
    	int k=5;
    	System.out.println(solution.maxNumber(num1,num2,k));
    	System.out.println("\r<br>执行耗时 : "+(System.currentTimeMillis()-a)/1000f+" 秒 ");
    }
}
