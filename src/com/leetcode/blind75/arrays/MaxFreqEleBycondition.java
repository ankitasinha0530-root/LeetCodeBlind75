package com.leetcode.blind75.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MaxFreqEleBycondition {

    // https://stackoverflow.com/questions/68325243/delete-elements-with-highest-frequency

    public static void main(String[] args) {

        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1, 2));
        list.add(Arrays.asList(1, 4));
        list.add(Arrays.asList(1, 3));
        list.add(Arrays.asList(1, 2));
        list.add(Arrays.asList(2, -1));
        list.add(Arrays.asList(2, -1));
        list.add(Arrays.asList(1, 2));
        list.add(Arrays.asList(1, 4));
        list.add(Arrays.asList(1, 3));
        list.add(Arrays.asList(1, 2));
        list.add(Arrays.asList(1, 5));
        list.add(Arrays.asList(2, -1));
        list.add(Arrays.asList(2, -1));

        System.out.println(findList(list));
    }

    private static List<Integer> findList(List<List<Integer>> queries) {

        List<Integer> resList = new ArrayList<>();
        Map<Integer, Integer> freqMap = new HashMap<>();
        // taking a list instead of because we have to extract elements from the middle as well
        List<Integer> tempList = new ArrayList<>();  // which will act as a stack and we will always remove element from end

        for (List<Integer> list : queries)

            if (list.get(0) == 1) {
                int num = list.get(1);   // if the query input is 1 then add in map and tempList(stack)
                freqMap.put(num, freqMap.getOrDefault(num, 0) + 1); // a
                tempList.add(num);
            } else {
                System.out.println("tempList before Removing = " + tempList);
                System.out.println("freqMap before removing = " + freqMap);
                if (list.get(0) == 2) {
                    int maxFreq = 0;
                    int maxFreqEle = 0;

                    for (int num : tempList) {
                        if (freqMap.get(num) > maxFreq) { // loop over tempList and find max frequency from the map by checking the values
                            maxFreq = freqMap.get(num);
                            maxFreqEle = num;
                        }
                    }

                    Set<Integer> set = new HashSet<>();  // put all the elements with max freq in a set
                    for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
                        if (entry.getValue() == maxFreq) {
                            set.add(entry.getKey()); // add to set, contain 1 or more elements with max freq
                        }
                    }
                    System.out.println("Elements in set  = " + set);
                    int removeindex = -1;
                    for (int ele : set) {  // for each element in set (elements has max freq)
                        for (int i = tempList.size() - 1; i >= 0; i--) {        // loop in tempList from end and fins the index of occurence
                            if (ele == tempList.get(i)) {
                                removeindex = Math.max(i, removeindex);   // select the one with highest index, that will be on the open end
                            }
                        }
                    }

                    resList.add(tempList.get(removeindex)); // add to result list
                    freqMap.put(tempList.get(removeindex), freqMap.getOrDefault(tempList.get(removeindex), 0) - 1); // remove from map
                    tempList.remove(removeindex); // remove from Temp list
                    System.out.println("result List steps = " + resList);
                    System.out.println("freqMap after removing = " + freqMap);
                    System.out.println("tempList after removing= " + tempList);
                }
            }
        System.out.println("result List final = " + resList);
        System.out.println("freqMap final = " + freqMap);
        System.out.println("tempList final = " + tempList);
        return resList;

    }
}
