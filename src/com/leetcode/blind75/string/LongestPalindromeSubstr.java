package com.practice.leetcode.blind75.string;

public class LongestPalindromeSubstr {

    public static void main(String[] args) {

        String str = "EBBABAD";
        String str1 = "EBBABABD";
        System.out.println(longestPalindromeSubstr(str));
        System.out.println(longestPalindromeSubstr(str1));
    }
    // https://www.youtube.com/watch?v=uX0-xyPkR2w

    private static String longestPalindromeSubstr(String str) {

        String ans = "";
        for (int i = 1; i < str.length(); i++) {

            // for Odd
            int low = i;
            int high = i;
            String pans = findPalindrome(str, low, high);

            if (pans.length() > ans.length()) {
                ans = pans;
            }

            // for Even
            low = i - 1;
            high = i;
            pans = findPalindrome(str, low, high);

            if (pans.length() > ans.length()) {
                ans = pans;
            }
        }
        return ans;
    }

    private static String findPalindrome(String str, int low, int high) {
        while (str.charAt(low) == str.charAt(high)) {
            low--;
            high++;
            if (low == -1 || high == str.length()) {
                break;
            }
        }
        String pAns = str.substring(low + 1, high);

        return pAns;
    }

}
