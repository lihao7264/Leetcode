package com.atlihao.leetcode.array.one;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lihao
 * @ClassName SingleNumber
 * @Since 2020/2/5
 * @Description 136、只出现一次的数字
 * https://leetcode.cn/problems/single-number/
 * 题目详情：给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 难度：简单
 * 解法：异或两个相同的数字得到结果为0，所以异或整个数组中值即可
 * 1^1=0 0^0=0  0^1=1 1^0=1
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 1, 4, 5, 4};
        int i = singleNumber(nums);
        System.out.println(i);
    }

    public static int singleNumber(int[] nums) {
       return singleNumberWithXOR(nums);
//       return singleNumberWithSet(nums);
    }


    /**
     * 使用异或方式
     * Time(时间复杂度)：O(n)、Space(空间复杂度):O(1)
     *
     * @param nums
     * @return
     */
    public static int singleNumberWithXOR(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = result ^ num;
        }
        return result;
    }

    /**
     * 使用Set辅助去重*2-原值
     * Time(时间复杂度)：O(n)、Space(空间复杂度):O(n)
     *
     * @param nums
     * @return
     */
    public static int singleNumberWithSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        int uniqueSum = 0;
        for (int num : nums) {
            if (!set.contains(num)) {
                uniqueSum += num;
                set.add(num);
            }
            sum += num;
        }
        uniqueSum *= 2;
        return uniqueSum * 2 - sum;
    }
}
