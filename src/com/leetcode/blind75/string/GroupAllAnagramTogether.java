package com.leetcode.blind75.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAllAnagramTogether {

    // 	https://www.youtube.com/watch?v=C9V66KyZCP8

    public static void main(String[] args) {

        String[] stringArr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAllAnagramsTogether(stringArr));
        System.out.println(groupAllAnagramsTogetherV2(stringArr));
    }

    private static List<List<String>> groupAllAnagramsTogether(String[] stringArr) {

        Map<String, List<String>> anagramGroupMap = new HashMap<>();
        for (int j = 0; j < stringArr.length; j++) {

            //		1st Sort the characters
            char[] chars = stringArr[j].toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            // check if the map already has this sorted list then add to that keys value
            if (anagramGroupMap.containsKey(sorted)) {
                anagramGroupMap.get(sorted).add(stringArr[j]);
            } else {
                List<String> strList = new ArrayList<>(); // if the sorted is not present then create new list and then add to map
                strList.add(stringArr[j]);
                anagramGroupMap.put(sorted, strList);    // Key will be sorted element and value will be actual element
            }
        }
        return new ArrayList<>(anagramGroupMap.values());
    }

    private static List<List<String>> groupAllAnagramsTogetherV2(String[] stringArr) {

        Map<String, List<String>> anagramGroupMap = new HashMap<>();

        for (String str : stringArr) {

            String freqString = findFrequency(str);

            if (anagramGroupMap.containsKey(freqString)) {
                anagramGroupMap.get(freqString).add(str);
            } else {
                List<String> strList = new ArrayList<>();
                strList.add(str);
                anagramGroupMap.put(freqString, strList);
            }
        }
        return new ArrayList<>(anagramGroupMap.values());
    }

    private static String findFrequency(String str) {
        int[] charFreq = new int[26];

        for (char c : str.toCharArray()) {
            charFreq[c - 'a']++;
        }
        StringBuilder freqStr = new StringBuilder();
        char ch = 'a';
        for (int value : charFreq) {
            freqStr.append(ch);
            freqStr.append(value);
            ch++;
        }

        return freqStr.toString();
    }
}
