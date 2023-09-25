package com.atlihao.leetcode.dynamic.ten;

/**
 * @Author: lihao7264
 * @Description: 983. 最低票价
 * @Date 2023/9/24 21:34
 * https://leetcode.cn/problems/minimum-cost-for-tickets/
 * 在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出。每一项是一个从 1 到 365 的整数。
 * 火车票有 三种不同的销售方式 ：
 * 一张 为期一天 的通行证售价为 costs[0] 美元；
 * 一张 为期七天 的通行证售价为 costs[1] 美元；
 * 一张 为期三十天 的通行证售价为 costs[2] 美元。
 * 通行证允许数天无限制的旅行。
 * 如果我们在第 2 天获得一张 为期 7 天 的通行证，那么我们可以连着旅行 7 天：第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。
 * 返回:想完成在给定的列表 days 中列出的每一天的旅行所需的最低消费 。
 * * 笔记地址：https://www.yuque.com/lijiaxiaodi/arv96m/ha87lyoeh3983w43#rZpod
 */
public class MinCostTickets {


    public static void main(String[] args) {
        System.out.println(mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15}));
    }

    /**
     * 动态规划解法
     *
     * @param days
     * @param costs
     * @return
     */
    public static int mincostTickets(int[] days, int[] costs) {
//        int[] result = new int[days.length + 1];
//        Arrays.fill(result, 365 * 1000 + 1);
//        result[0] = 0;
//        for (int i = 0; i < result.length; i++) {
//
//        }
        return 0;
    }
}
