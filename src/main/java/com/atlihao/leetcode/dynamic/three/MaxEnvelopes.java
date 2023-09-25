package com.atlihao.leetcode.dynamic.three;

import com.atlihao.leetcode.dynamic.two.LengthOfLIS;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: lihao7264
 * @Date 2023/9/25 22:31
 * @Description: 354. 俄罗斯套娃信封问题
 * https://leetcode.cn/problems/russian-doll-envelopes/description/
 * 给你一个二维整数数组 envelopes（envelopes[i] = [wi, hi]：表示第 i 个信封的宽度和高度）。
 * 当另一个信封的宽度和高度都比该信封大时，该信封可放进另一个信封里，如同俄罗斯套娃一样。
 * 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * 注意：不允许旋转信封。
 * * 笔记地址：https://www.yuque.com/lijiaxiaodi/arv96m/tookbcqdbh1u25my
 */
public class MaxEnvelopes {

    public static void main(String[] args) {
        System.out.println(maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}}));
    }

    public static int maxEnvelopes(int[][] envelopes) {
        int num = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });
        int[] height = new int[num];
        for (int i = 0; i < num; i++) {
            height[i] = envelopes[i][1];
        }
//        return LengthOfLIS.lengthOfLIS(height);
//        return LengthOfLIS.lengthOfLIS2(height);
    }
}

