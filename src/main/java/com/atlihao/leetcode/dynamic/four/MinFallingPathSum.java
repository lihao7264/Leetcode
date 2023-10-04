package com.atlihao.leetcode.dynamic.four;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @author lihao7264
 * @ClassName MinFallingPathSum
 * @Since 2023/9/24
 * @Description 931. 下降路径最小和
 * https://leetcode.cn/problems/minimum-falling-path-sum/
 * 说明：
 * 1. 一个 n x n 的 方形 整数数组 matrix ，请找出并返回通过 matrix 的下降路径 的 最小和（即从第一行落到最后一行，经过的路径和最小为多少） 。
 * 2. 下降路径：可从第一行中的任何元素开始 并 从每一行中选择一个元素。
 * ○ 在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方 或 沿对角线向左/向右的第一个元素）。
 * ○ 位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 、(row + 1, col + 1) 。
 * ■ 每次下降，可向下、向左下、向右下三个方向移动一格（即可从 matrix[i][j] 降到 matrix[i+1][j]、matrix[i+1][j-1]、matrix[i+1][j+1] 三个位置）。
 * 笔记地址：https://www.yuque.com/lijiaxiaodi/arv96m/lodgp3hihfgsa5mg
 */
public class MinFallingPathSum {

    public static void main(String[] args) {
        LocalDateTime startTime = LocalDateTime.now();
        System.out.println(minFallingPathSum(new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}}));
        LocalDateTime finishTime = LocalDateTime.now();
        System.out.println(Duration.between(startTime, finishTime));
    }

    public static int minFallingPathSum(int[][] matrix) {
//        Integer result = 99999;
//        for (int i = 0; i < matrix.length; i++) {
//            result = Math.min(result, dp1(matrix, matrix.length - 1, i));
//        }
//        return result;

        Integer result = 99999;
        memo = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], 99999);
        }
        for (int i = 0; i < matrix.length; i++) {
            result = Math.min(result, dp2(matrix, matrix.length - 1, i));
        }
        return result;

    }

    /**
     * 解法一：暴力递归
     * matrix = [[2,1,3],[6,5,4],[7,8,9]]
     * 输出：13
     * 耗时：5分钟以上
     *
     * @param matrix
     * @return
     */
    public static int dp1(int[][] matrix, int i, int j) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
            return 99999;
        }
        // base case
        if (i == 0) {
            return matrix[i][j];
        }
        return matrix[i][j] + Math.min(dp1(matrix, i - 1, j - 1), Math.min(dp1(matrix, i - 1, j), dp1(matrix, i - 1, j + 1)));
    }

    /**
     * 解法二：带备案录的递归
     * coins：1,2,5
     * amount：100
     * 耗时：1ms
     *
     * @param coins
     * @param amount
     * @return
     */
    private static int[][] memo;

    public static int dp2(int[][] matrix, int i, int j) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
            return 99999;
        }
        // base case
        if (i == 0) {
            return matrix[i][j];
        }
        if (memo[i][j] != 99999) {
            return memo[i][j];
        }
        int min = matrix[i][j] + Math.min(dp2(matrix, i - 1, j - 1), Math.min(dp2(matrix, i - 1, j), dp2(matrix, i - 1, j + 1)));
        memo[i][j] = min;
        return min;
    }
}