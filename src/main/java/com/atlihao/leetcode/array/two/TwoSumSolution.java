package com.atlihao.leetcode.array.two;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 两数之和
 * @Author: lihao7264
 * @CreateDate: 2021/11/16 1:12 下午
 * @UpdateUser: lihao7264
 * @UpdateDate: 2021/11/16 1:12 下午
 * @Version: 1.0.0
 */
public class TwoSumSolution {

    public int[] twoSum(int[] nums, int target) {
        return getTwoNumSumToGivenValueHashMap(nums, target);
    }


    /**
     * 暴力破解法
     * Time(时间复杂度)：O(n^2)、Space(空间复杂度):O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] getTwoNumSumToGivenValueBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * Map下标法（最优解）
     * Time(时间复杂度)：O(n)、Space(空间复杂度):O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] getTwoNumSumToGivenValueHashMap(int[] nums, int target) {
        Map<Integer, Integer> targetMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer result = target - nums[i];
            if (targetMap.containsKey(result)) {
                return new int[]{i, targetMap.get(result)};
            }
            targetMap.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
