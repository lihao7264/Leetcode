package com.atlihao.leetcode.dynamic.one;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @author lihao7264
 * @ClassName CoinChange
 * @Since 2023/9/24
 * @Description 322. 零钱兑换
 * https://leetcode.cn/problems/coin-change/
 * 说明：给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * 一个整数数组 coins（表示不同面额的硬币）；一个整数 amount（表示总金额）。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。
 * 笔记地址：https://www.yuque.com/lijiaxiaodi/arv96m/ha87lyoeh3983w43#rZpod
 */
public class CoinChange {

    public static void main(String[] args) {
        LocalDateTime startTime = LocalDateTime.now();
        System.out.println(coinChange(new int[]{1, 2, 5}, 100));
        LocalDateTime finishTime = LocalDateTime.now();
        System.out.println(Duration.between(startTime, finishTime));
    }

    public static int coinChange(int[] coins, int amount) {
//        return dp1(coins, amount);

//        memo = new int[amount + 1];
//        Arrays.fill(memo, Integer.MAX_VALUE);
//        return dp2(coins, amount);

        memo = new int[amount + 1];
        Arrays.fill(memo, amount + 1);
        return dp3(coins, amount);
    }

    /**
     * 解法一：暴力递归
     * coins：1,2,5
     * amount：100
     * 耗时：5分钟以上
     *
     * @param coins
     * @param amount
     * @return
     */
    public static int dp1(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        Integer min = amount + 1;
        for (int coin : coins) {
            int subProblem = dp1(coins, amount - coin);
            if (subProblem == -1) {
                continue;
            }
            min = Math.min(min, subProblem + 1);
        }
        return min == amount + 1 ? -1 : min;
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
    private static int[] memo;

    public static int dp2(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (memo[amount] != Integer.MAX_VALUE) {
            return memo[amount];
        }
        Integer min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subProblem = dp2(coins, amount - coin);
            if (subProblem == -1) {
                continue;
            }
            min = Math.min(min, subProblem + 1);
        }
        memo[amount] = min == Integer.MAX_VALUE ? -1 : min;
        return memo[amount];
    }


    /**
     * 解法三：动态规划
     * coins：1,2,5
     * amount：100
     * 耗时：1ms
     *
     * @param coins
     * @param amount
     * @return
     */
    public static int dp3(int[] coins, int amount) {
        memo[0] = 0;
        for (int i = 0; i < memo.length; i++) {
            for (int coin : coins) {
                if ((i - coin) < 0) {
                    continue;
                }
                memo[i] = Math.min(memo[i], memo[i - coin] + 1);
            }
        }
        return memo[amount] == amount + 1 ? -1 : memo[amount];
    }
}
