package com.leetcode.blind75.string;

public class ValidPalindrome {

    public static void main(String[] args) {

        String str = "A man, a plan, a canal: Panama";
        String str2 = "race a car";
        System.out.println(isValidPalindrome(str));
        System.out.println(isValidPalindrome(str2));
    }

    private static boolean isValidPalindrome(String str) {

        str = str.toLowerCase().replaceAll("[^A-Za-z0-9]", "");

        System.out.println(str);

        int left = 0, right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
}
