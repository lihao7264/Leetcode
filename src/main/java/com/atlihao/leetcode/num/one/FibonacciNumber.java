package com.atlihao.leetcode.num.one;

/**
 * @author lihao
 * @ClassName FibonacciNumber
 * @Since 2020/2/9
 * @Description 509、斐波那契数
 * https://leetcode.cn/problems/fibonacci-number/
 * 斐波那契数，通常用F(n) 表示，形成的序列称为斐波那契数列。该数列由0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * F(0) = 0, F(1)= 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列的例子：0 1 1 2 3 5 8 13 ...
 */
public class FibonacciNumber {

    /**
     * 1、解法一：暴力递归
     * 时间复杂度：O(2^n)
     *
     * @param N
     * @return
     */
    public int fib1(int N) {
        if (N <= 1) {
            return N;
        }
        return fib1(N - 1) + fib1(N - 2);
    }

    /**
     * 2、解法二：for循环计算
     * 时间复杂度：O(n)
     * 位置：       0 1 2 3 4 5 6 7
     * 斐波那契数列：0 1 1 2 3 5 8 13 ...
     * 算法举例一：
     *   a、如果n=2，则需要计算1次。
     *   b、如果n=3，则需要计算2次。(即0+1、1+2)
     *   c、总结：入参n，需计算n-1次
     *  算法举例二：
     *   a、如果n=3，则第一次计算位置0+位置1 且 赋值给位置2。(first：位置0，second：位置1)
     *   b、第二次计算位置1+位置2 且 赋值给位置3(最终返回second的值)。(first：位置1(即上次计算的second值)，second：位置2(即上次计算的结果))
     *
     * @param N
     * @return
     */
    public int fib2(int N) {
        if (N <= 1) {
            return N;
        }
        int first = 0;
        int second = 1;
        for (int i = 0; i < N - 1; i++) {
            ////代码1：
//            int sum = first + second;
//            first = second;
//            second = sum;

            //代码2：节省一个变量
            second += first;
            first = second - first;
        }
        return second;
    }

    /**
     * 3、解法三：斐波那契数的特征方程
     * 时间复杂度：O(1)
     *
     * @param N
     * @return
     */
    public int fib3(int N) {
        // 根号5
        double sqrt = Math.sqrt(5);
        return (int) ((Math.pow((1 + sqrt) / 2, N) - Math.pow((1 - sqrt) / 2, N)) / sqrt);
    }
}
