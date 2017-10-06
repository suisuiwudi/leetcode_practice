package leetcode_468;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public String validIPAddress(String IP) {
        Pattern ipv4 = Pattern.compile("^(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9]?[0-9])\\.(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9]?[0-9])\\.(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9]?[0-9])\\.(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9]?[0-9])$");
        Matcher mipv4 = ipv4.matcher(IP);
        Pattern ipv6 = Pattern.compile("^([0-9a-fA-F]{1,4}:){7,7}[0-9a-fA-F]{1,4}$");
        Matcher mipv6 = ipv6.matcher(IP);
        if (mipv4.matches()){
            return "IPv4";
        } else if (mipv6.matches()){
            return "IPv6";
        }
        return "Neither";
    }
}
