package com.leetcode.blind75.string;

import java.util.HashMap;
import java.util.Map;

public class CountOfLongestNonRepeatSubString {

    // https://www.youtube.com/watch?v=BKy7H8rEmco

    public static void main(String[] args) {

        String s = "abcabcdbb";
        String s2 = "babcabbcdba";

        String s3 = "bbbcad";

        //	System.out.println(longestNonRepeatSubStringCount(s));
        System.out.println(longestNonRepeatSubStringCount(s3));

    }

    private static int longestNonRepeatSubStringCount(String s) {
        int maxCount = 0;
        int left = 0, right = 0;

        char[] strArr = s.toCharArray();

        Map<Character, Integer> map = new HashMap<>();

        for (right = 0; right < strArr.length; right++) {

            int idx = map.getOrDefault(strArr[right], -1);
            if (idx != -1 && idx >= left) {
                maxCount = Math.max(maxCount, right - 1 - left + 1);
                left = idx + 1;
            }

            map.put(strArr[right], right);
        }

        return Math.max(maxCount, right - 1 - left + 1);
    }

}
