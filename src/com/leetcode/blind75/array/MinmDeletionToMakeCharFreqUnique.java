package com.practice.leetcode.blind75.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinmDeletionToMakeCharFreqUnique {

	public static void main(String[] args) {
		String s = "aaabbbcc";
		String s1 = "bbcebab";
		System.out.println(minDeletions(s));

	}

	public static int minDeletions(String s) {
		if (s.length() < 2) {
			return 0;
		}
		Map<Character, Integer> freqMap = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			freqMap.put(s.charAt(i), freqMap.getOrDefault(s.charAt(i), 0) + 1);
		}

		Set<Integer> freq = new HashSet<>();
		int count = 0;

		for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
			if (!freq.contains(entry.getValue())) {
				freq.add(entry.getValue());
			} else {
				
				while (entry.getValue() != 0 && freq.contains(entry.getValue())) {
					freqMap.put(entry.getKey(), freqMap.get(entry.getKey()) - 1);
					count++;
					
					}
				freq.add(entry.getValue());

				}
			}

		
		return count;
	}
}
