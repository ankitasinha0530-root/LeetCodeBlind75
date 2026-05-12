package com.leetcode.blind75.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class BobAndPipeProblem {

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
        list.add(Arrays.asList(2, -1));
        list.add(Arrays.asList(2, -1));

        System.out.println(findList(list));
    }

    private static List<Integer> findList(List<List<Integer>> queries) {

        List<Integer> resList = new ArrayList<>();
        Map<Integer, Integer> freqMap = new HashMap<>();
        List<Integer> tempList = new ArrayList<>();

        for (List<Integer> list : queries)

            if (list.get(0) == 1) {
                int num = list.get(1);
                freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
                tempList.add(num);
                System.out.println("tempList = " + tempList);
            } else {
                if (list.get(0) == 2) {
                    PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
                            (i1, i2) -> i2.getValue() - i1.getValue());
                    for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
                        maxHeap.add(entry);
                    }
                    System.out.println("maxHeap pushed data = " + maxHeap);

                    Map.Entry<Integer, Integer> entry = maxHeap.poll();
                    System.out.println("entry = " + entry);

                    if (maxHeap.size() > 1) {
                        if (entry.getValue() > maxHeap.peek().getValue()) {
                            resList.add(entry.getKey());

                            freqMap.put(entry.getKey(), freqMap.getOrDefault(entry.getKey(), 0) - 1);

                            int removeIdx = -1;
                            for (int i = tempList.size() - 1; i >= 0; i--) {
                                if (entry.getKey() == tempList.get(i)) {
                                    removeIdx = i;
                                    System.out.println("i = " + i);
                                    break;
                                }
                            }
                            System.out.println("maxIdx = " + removeIdx);
                            tempList.remove(removeIdx);
                            System.out.println("tempList in if = " + tempList);

                        } else {
                            int maxIdx = -1;
                            while (!maxHeap.isEmpty()) {
                                if (maxHeap.size() > 0 && entry.getValue() == maxHeap.peek().getValue()) {

                                    System.out.println("entry in else = " + entry);
                                    System.out.println("tempList in else = " + tempList);

                                    for (int i = tempList.size() - 1; i >= 0; i--) {
                                        if (entry != null && entry.getKey() == tempList.get(i)) {
                                            maxIdx = Math.max(maxIdx, i);
                                            System.out.println("maxIdx = " + maxIdx);
                                        }
                                    }

                                    entry = maxHeap.poll();
                                    System.out.println("Entry Last " + entry);
                                    if (maxHeap.size() == 0) {
                                        System.out.println("Entry Last else**** " + entry);
                                        for (int i = tempList.size() - 1; i >= 0; i--) {
                                            if (entry != null && entry.getKey() == tempList.get(i)) {
                                                maxIdx = Math.max(maxIdx, i);
                                                System.out.println("maxIdx = " + maxIdx);
                                            }
                                        }
                                    }

                                } else {
                                    break;
                                }

                            }
                            resList.add(tempList.get(maxIdx));
                            freqMap.put(tempList.get(maxIdx), freqMap.getOrDefault(tempList.get(maxIdx), 0) - 1);
                            System.out.println("maxIdx = " + maxIdx);
                            tempList.remove(maxIdx);
                        }
                    }
                }
            }
//		System.out.println("maxHeap = " + maxHeap);
        System.out.println("freqMap = " + freqMap);
        System.out.println("tempList = " + tempList);
        System.out.println("resList = " + resList);
        return resList;

    }
}
