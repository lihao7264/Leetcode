package com.atlihao.leetcode.array.three;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 两数之和 II - 输入有序数组
 * @Author: lihao7264
 * @CreateDate: 2021/11/16 9:53 下午
 * @UpdateUser: lihao7264
 * @UpdateDate: 2021/11/16 9:53 下午
 * @Version: 1.0.0
 */
public class TwoSum2ForOrderedArraySolution {

    public int[] twoSum(int[] numbers, int target) {
        return getTwoNumSumToGivenValue(numbers, target);
    }

    /**
     * 双指针法（最优解）
     * Time(时间复杂度)：O(n)、Space(空间复杂度):O(1)
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] getTwoNumSumToGivenValue(int[] numbers, int target) {
        Integer i = 0;
        Integer j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] < target) {
                ++i;
            } else if (numbers[i] + numbers[j] > target) {
                --j;
            } else {
                return new int[]{i+1, j+1};
            }
        }
        return new int[]{-1, -1};
    }
}
