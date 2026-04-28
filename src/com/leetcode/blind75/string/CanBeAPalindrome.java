package com.practice.leetcode.blind75.string;

import java.util.HashMap;
import java.util.Map;

public class CanBeAPalindrome {

	public static void main(String[] args) {
		
		String s = "aabbcccdd";
		String s1 = "aabbbc";
		String s2 = "c";
		System.out.println(canBeAPalindrome(s));
		System.out.println(canBeAPalindrome(s1));
		System.out.println(canBeAPalindrome(s2));
	}

	private static boolean canBeAPalindrome(String s) {
		
		if(s.length() == 1) {
			return true;
		}
		int count = 0;
		
		Map<Character, Integer> freqMap = new HashMap<>();
		
		for(char ch : s.toCharArray()) {
			freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
		}
		
		for(Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
			if(entry.getValue()%2 == 1) {
				count++;
				if(count > 1) {
					return false;
				}
			}
		}
		
		return true;
	}

}
