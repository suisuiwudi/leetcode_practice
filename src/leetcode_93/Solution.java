package leetcode_93;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<String> ans;
    public List<String> restoreIpAddresses(String s) {
        ans = new ArrayList();
        StringBuilder sb = new StringBuilder(s);
        StringBuilder ge = new StringBuilder();
        helper(sb, 0, ge, 0);
        return ans;
    }
    public void helper(StringBuilder original, int index, StringBuilder generate, int dot){
        if (dot == 3){
            String addressString = original.substring(index);
            if (addressString.length() > 3) return;
            int addressInt =  Integer.parseInt(addressString);
            if (addressInt < 0 || addressInt > 255) return;
            if (!Integer.toString(addressInt).equals(addressString)) return;
            ans.add(generate.append('.').append(addressInt).substring(1));
            generate.delete(generate.length() - addressString.length() - 1, generate.length());
            return;
        }
        for (int i = 0; i < Math.min(3, original.length() - index - 1); i++){
            String addressString = original.substring(index, index + i + 1);
            int addressInt =  Integer.parseInt(addressString);
            if (addressInt < 0 || addressInt > 255) continue;
            if (!Integer.toString(addressInt).equals(addressString)) continue;
            generate.append('.').append(addressInt);
            helper(original, index + i + 1, generate, dot + 1);
            generate.delete(generate.length() - i - 2, generate.length());
        }
    }
}