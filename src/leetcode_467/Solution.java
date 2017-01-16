package leetcode_467;

public class Solution {
	  public int findSubstringInWraproundString(String p) {
		  int n= p.length();
		  if (n == 0) return 0;
		  int cnt_Array[] = new int[26];		  
		  int last_pos = 0;
		  cnt_Array[p.charAt(0)-'a'] = 1;
	      for ( int i = 1; i < n ; i++){
	    	  if ( p.charAt(i) == p.charAt(i-1) + 1 || p.charAt(i)+25 == p.charAt(i-1)) {	    	
	    		  cnt_Array[p.charAt(i)-'a'] = Math.max(cnt_Array[p.charAt(i)-'a'] , i - last_pos + 1);	  	    	
	    	  }else{ 	
	    		  last_pos = i;
	    		  cnt_Array[p.charAt(i)-'a'] = Math.max(cnt_Array[p.charAt(i)-'a'] , 1);	  	    	
	    	  }
	      }
	      int ans = 0;
	      for (int i = 0; i < 26 ; i++)
	    	  ans += cnt_Array[i];
	      return ans;
	      
	  }
}
