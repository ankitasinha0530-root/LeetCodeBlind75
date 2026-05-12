package com.leetcode.blind75.string;

public class ValidAnagram {

    public static void main(String[] args) {

        // Two strings S1 and S2 have same characters but are arranged differently
        // eg Silent and Listen, "anagram" & "nagaram"

        String s1 = "Silent", s2 = "Listen";
        String s3 = "anagram", s4 = "nagaram";
        String s5 = "car", s6 = "rat";

        System.out.println(isValidAnagram(s1, s2));
        System.out.println(isValidAnagram(s5, s6));
    }

    private static boolean isValidAnagram(String s1, String s2) {
        int[] charFreq = new int[26];

        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        for (int i = 0; i < s1.length(); i++) {
            charFreq[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            charFreq[s2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < charFreq.length; i++) {
            if (charFreq[i] != 0) {
                return false;
            }
        }
        return true;
    }

}
