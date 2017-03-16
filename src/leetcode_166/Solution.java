package leetcode_166;

import java.util.HashMap;

public class Solution {
	public String fractionToDecimal(int numerator, int denominator) {
		boolean negativeFlag = false;
		long nume = (long) numerator;
		long deno = (long) denominator;
		if (nume < 0 && deno < 0) {
			nume = -nume;
			deno = -deno;
		} else if (nume < 0) {
			nume = -nume;
			negativeFlag = true;
		} else if (deno < 0) {
			deno = -deno;
			negativeFlag = true;
		}
		long integer = 0;
		long remain = nume;
		if (nume >= deno) {
			integer = nume / deno;
			remain = nume % deno;
		}
		StringBuilder sb = new StringBuilder();
		if (remain == 0) {
			if (integer > 0) {
				if (negativeFlag)
					sb.append('-');
				return sb.append(Long.toString(integer)).toString();
			} else
				return "0";
		}

		HashMap<Long, Integer> map = new HashMap<>();
		int flag = -1;
		int num = 0;
		map.put(remain, num);
		while (remain != 0) {
			remain *= 10;
			if (map.containsKey(remain)) {
				flag = map.get(remain);
				break;
			}
			map.put(remain, num++);
			long digit = remain / deno;
			remain = remain % deno;
			sb.append(Long.toString(digit));
		}
		if (flag >= 0) {
			sb.insert(flag, '(');
			sb.append(')');
		}
		StringBuilder ans = new StringBuilder();
		if (negativeFlag)
			ans.append('-');
		if (integer > 0)
			ans.append(Long.toString(integer));
		else
			ans.append('0');
		ans.append('.').append(sb);
		return ans.toString();
	}
}