package com.practice.leetcode.blind75.string;

import java.util.HashMap;
import java.util.Map;

public class MinmWindowSubStr {

	public static void main(String[] args) {

		String s = "ADOBECODEBANC", t = "ABC";
		
		System.out.println(findMinmWindowSubStr(s, t));
	}

	private static String findMinmWindowSubStr(String s1, String s2) {
		
	//	create frequency map of target string
		Map<Character, Integer> map2 = new HashMap<>();
		for (int i = 0; i < s2.length(); i++) {
			map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1);
		}
		
		int desiredCnt = s2.length();
		int matchCnt = 0;
		String ans = "";
		Map<Character, Integer> map1 = new HashMap<>();
		int i = -1, j = -1;
		
		while(true) {
			boolean f1 = false;
			boolean f2 = false;
		//	collect the element of map1 while keep on increasing the window
			while(i < s1.length() - 1 && matchCnt < desiredCnt){
				i++;
				char ch = s1.charAt(i);
				map1.put(ch, map1.getOrDefault(ch, 0) + 1);
				if(map1.getOrDefault(ch, 0) <= map2.getOrDefault(ch, 0)) {
					matchCnt++;
				}
				f1 = true;
			}
			
	//		collect answer release since we have all (more than)the elements of map 2 collected in map1
			while(j < i && matchCnt == desiredCnt) {
		//		collect answer
				String potAns = s1.substring(j+1, i+1);
				if(ans.length() == 0 || potAns.length() < ans.length()) {
					ans = potAns;
				}
				//release element from start of the window
				j++;
				char ch = s1.charAt(j);
				if(map1.get(ch) == 0) {
					map1.remove(ch);
				}else {
					map1.put(ch, map1.getOrDefault(ch, 0)-1);
				}
				if(map1.getOrDefault(ch, 0) < map2.getOrDefault(ch, 0)) {
					matchCnt--;
				}
				f2 = true;
			}
			
			if(f1 ==  false && f2 == false) {
				break;
			}
		}
		return ans;
	}

}
