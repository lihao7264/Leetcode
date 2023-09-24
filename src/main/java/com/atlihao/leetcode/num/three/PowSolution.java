package com.atlihao.leetcode.num.three;

/**
 * @Description: 50. Pow(x, n)
 * https://leetcode.cn/problems/powx-n/
 * @Author: lihao7264
 * @CreateDate: 2021/11/23 11:17 下午
 * @UpdateUser: lihao7264
 * @UpdateDate: 2021/11/23 11:17 下午
 * @Version: 1.0.0
 */
public class PowSolution {
    public static void main(String[] args) {
        myPow(2.000, 10);
    }

    public static double myPow(double x, int n) {
        return pow(x, n);
    }


    /**
     * 迭代方式
     * Time(时间复杂度)：O(n)、Space(空间复杂度):O(1)
     *
     * @param x
     * @param n
     * @return
     */
    private static double pow(double x, int n) {
        double res = 1;
        long N = Math.abs((long) n);// 如果n是int的最小值的话，取绝对值会溢出，所以使用long
        for (int i = 0; i < N; ++i) {
            res *= x;
        }
        return n < 0 ? 1 / res : res;
    }


    /**
     * 折半迭代方式（按照位进行）
     * Time(时间复杂度)：O(logn)、Space(空间复杂度):O(1)
     *
     * @param x
     * @param n
     * @return
     */
    private static double powFast(double x, int n) {
        double res = 1;
        long N = Math.abs((long) n);// 如果n是int的最小值的话，取绝对值会溢出，所以使用long
        while (N != 0) {
            if ((N & 1) == 1) {
                res *= x;
            }
            x *= x;
            N >>= 1;
        }
        return n < 0 ? 1 / res : res;
    }

}
