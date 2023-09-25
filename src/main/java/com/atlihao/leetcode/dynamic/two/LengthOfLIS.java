package com.atlihao.leetcode.dynamic.two;

import java.util.Arrays;

/**
 * @Author: lihao7264
 * @Date 2023/9/25 22:09
 * @Description 300. 最长递增子序列
 * https://leetcode.cn/problems/longest-increasing-subsequence/
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列:由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 举例：[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * 笔记地址：https://www.yuque.com/lijiaxiaodi/arv96m/bf2g3ai7dye0zbti
 */
public class LengthOfLIS {

    public static void main(String[] args) {
//        System.out.println(lengthOfLIS(new int[]{7, 7, 7}));
        System.out.println(lengthOfLIS2(new int[]{7, 7, 7}));
    }

    /**
     * 解法一：动态规划
     * 找出前面小于当前值的最大递增子序+1
     * 时间复杂度：o(n^2)
     *
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    result[i] = result[i] > (result[j] + 1) ? result[i] : result[j] + 1;
                }
            }
        }
        Integer max = 1;
        for (int num : result) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    /**
     * 解法二：动态规划
     * 找出前面小于当前值的最大递增子序+1
     * 时间复杂度：o(nlogn)
     *
     * @param nums
     * @return
     */
    public static int lengthOfLIS2(int[] nums) {
        int[] top = new int[nums.length];
        // 堆数
        int heapNum = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = 0;
            int right = heapNum;
            while (left < right) {
                // 二分
                int mid = (left + right) / 2;
                if (top[mid] > nums[i]) {
                    right = mid;
                } else if (top[mid] < nums[i]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            // 未找到合适的牌堆，新建一堆
            if (left == heapNum) {
                heapNum++;
            }
            // 把这张牌放到牌堆顶
            top[left] = nums[i];
        }
        return heapNum;
    }

}
