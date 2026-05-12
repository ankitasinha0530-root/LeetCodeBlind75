package com.leetcode.blind75.arrays;

public class ContainerWithMostWater {

    public static void main(String[] args) {

        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        int maxArea = findMaxArea(height);
        System.out.println(maxArea);

    }

    private static int findMaxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {

            int w = right - left;
            int h = Math.min(height[left], height[right]);
            int area = h * w;

            maxArea = Math.max(maxArea, area);

            if (height[left] < height[right])
                left++;
            else if (height[left] > height[right])
                right--;
            else {
                left++;
                right--;
            }
        }
        return maxArea;
    }
}
