package leetcode_321;

public class Solution {
    public String max(String a, String b){
//    	System.out.println(a);
//    	System.out.println(b);
        if (a.compareTo(b)>0) return a; else return b;
    }
    public String[] maxSingleArray(int[] num) {
        int n = num.length;
        if (n==0) return new String[1];
        String f[][] = new String[n][n+1];
        f[0][0]="";
        f[0][1]=""+num[0];
        for (int i=1;i<n;i++){
            for (int j=1;j<=i+1;j++){
            	if (f[i-1][j-1]==null) f[i-1][j-1]="";
            	if (i+1>j)
            		f[i][j]=max(f[i-1][j],f[i-1][j-1]+num[i]);
            	else 
            		f[i][j]=f[i-1][j-1]+num[i];
            }            
        }
        return f[n-1];
    }
    public String merge(String a, String b, int klength){
    	if (a=="" || a==null) return b;
    	if (b=="" || b==null) return a;
    	String ans = "";
    	int j=0, k=0;
    	for (int i=0; i<klength && j<a.length() && k<b.length();i++) {
    		boolean chooseb = false;
    		for (int l=0;j+l<=a.length() && k+l<=b.length();l++){
        		if (j+l == a.length()) { chooseb=true; break; }
        		else if (k+l == b.length()) break; 
    			if (a.charAt(j+l)>b.charAt(k+l)){
	    			break;
	    		}else if (a.charAt(j+l)<b.charAt(k+l)){
	    			chooseb = true;
	    			break;    		
	    		}
    		}

    		if (chooseb) 
    			ans=ans+b.charAt(k++);
    		else
    			ans=ans+a.charAt(j++);
    	}
    	for (;j<a.length();j++) ans=ans+a.charAt(j);
    	for (;k<b.length();k++) ans=ans+b.charAt(k);
//    		System.out.println(a+a.charAt(1));

    	return ans;
    }
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n=nums1.length;
        int m=nums2.length;
        String[] fn = maxSingleArray(nums1);
        String[] fm = maxSingleArray(nums2);
        String ans = "";
        for (int i=0; i<=k; i++)
        	if (i<=n && k-i<=m){
        		ans= max(ans,merge(fn[i],fm[k-i],k));
        	}
        System.out.println(ans);
        int int_ans[] = new int[k];
        for (int i=0; i<k; i++){
            int_ans[i]=ans.charAt(i)-48;
//            System.out.println(int_ans[i]);
        }
        return int_ans;
    }
}