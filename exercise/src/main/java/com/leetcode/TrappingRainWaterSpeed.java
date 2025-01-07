package com.leetcode;

//inspired by sent solution
public class TrappingRainWaterSpeed implements TrappingRainWater {

    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }

        int left = 0, leftPeak = height[left];
        int right = height.length - 1, rightPeak = height[right];
        int totalWater = 0;


        while (left < right) {

            if (leftPeak <= rightPeak) {
                totalWater += leftPeak - height[left];
                left++;
                leftPeak = Math.max(height[left], leftPeak);
            } else {
                totalWater += rightPeak - height[right];
                right--;
                rightPeak = Math.max(height[right], rightPeak);
            }
        }
        return totalWater;
    }
}
