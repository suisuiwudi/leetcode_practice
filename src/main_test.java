/*
 * this class is to test some recent cases I am dealing with 
 * and it will always change 
 * if you want to look at the performance 
 * go to leetcode website and submit the code in other folder or make main() yourself 
 */

import leetcode_491.*;
import java.util.List;
import java.util.ArrayList;

public class main_test {

    public static void main(String[] args) {
    	long a=System.currentTimeMillis();
    	Solution solution = new Solution();			
    	int num[] = { 4, 6, 7, 7};
    	List<Integer> c = new ArrayList<Integer>();
    	List<Integer> d = new ArrayList<Integer>();
    	c.add(123);
    	d = c;
    	System.out.println(d.size());
    	c.remove(c.size()-1);
    	System.out.println(d.size());
    	List<List<Integer>> b = solution.findSubsequences(num);
    	System.out.println("\r<br>执行耗时 : "+(System.currentTimeMillis()-a)/1000f+" 秒 ");
}
