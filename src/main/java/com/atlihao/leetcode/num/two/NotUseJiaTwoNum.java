package com.atlihao.leetcode.num.two;

/**
 * @Description: 不用+/-求两数之和
 * https://leetcode.cn/problems/sum-of-two-integers/
 * @Author: lihao7264
 * @CreateDate: 2021/11/18 9:16 下午
 * @UpdateUser: lihao7264
 * @UpdateDate: 2021/11/18 9:16 下午
 * @Version: 1.0.0
 */
public class NotUseJiaTwoNum {

    public int getSum(int a, int b) {
        return getSumRecursive(a, b);
    }

    /**
     * 递归方式
     *
     * @param a
     * @param b
     * @return
     */
    public int getSumRecursive(int a, int b) {
        return b == 0 ? a : getSumRecursive(a ^ b, (a & b) << 1);
    }

    /**
     * 迭代方式
     * Time(时间复杂度)：O(m)、Space(空间复杂度):O(1)
     *
     * @param a
     * @param b
     * @return
     */
    public int getSumIterative(int a, int b) {
        while (a != 0 && b != 0) {
            int i = a ^ b;
            int j = (a & b) << 1;
            a = i;
            b = j;
        }
        return a == 0 ? b : a;
    }

}
