package com.leetcode.blind75.string;

public class AllPalindromicSubString {

    //	https://www.youtube.com/watch?v=gI1771HyXu0
    public static void main(String[] args) {

        String str = "aaa";
        String str1 = "aaabb";
        System.out.println(findAllPalindromeCount(str));
        System.out.println(findAllPalindromeCount(str1));
    }

    // consider element selected as a middle element and then proceed left-- and right++ and check if its still a palindrome
    private static int findAllPalindromeCount(String str) {
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            //for Odd
            int low = i;
            int high = i;
            result = expandIntheMiddle(str, low, high, result);
            System.out.println("******" + result);

            low = i;
            high = i + 1;
            result = expandIntheMiddle(str, low, high, result);
            System.out.println("========" + result);

        }
        // TODO Auto-generated method stub
        return result;
    }

    private static int expandIntheMiddle(String str, int low, int high, int result) {
        while ((low >= 0 && high < str.length()) && str.charAt(low) == str.charAt(high)) {
            result++;
            low--;
            high++;

        }
        return result;
    }

}
