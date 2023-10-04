package com.atlihao.leetcode.dynamic.five;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @author lihao7264
 * @ClassName MinFallingPathSum
 * @Since 2023/9/24
 * @Description 115. 不同的子序列
 * https://leetcode.cn/problems/distinct-subsequences/submissions/
 * 说明：
 * 两个字符串 s 和 t ，统计并返回在 s 的 子序列 中 t 出现的个数，结果需对 10^9 + 7 取模。
 * 笔记：https://www.yuque.com/lijiaxiaodi/arv96m/gwgk4egepotf30h0#hvtQE
 */
public class NumDistinct {

    public static void main(String[] args) {
        LocalDateTime startTime = LocalDateTime.now();
        System.out.println(numDistinct("rabbbit", "rabbit"));
        LocalDateTime finishTime = LocalDateTime.now();
        System.out.println(Duration.between(startTime, finishTime));
    }

    public static int numDistinct(String s, String t) {
//        return dp1(s, 0, t, 0);
//        memo = new int[s.length()][t.length()];
//        for (int[] row : memo) {
//            Arrays.fill(row, -1);
//        }
//        return dp2(s, 0, t, 0);

        memo = new int[s.length()][t.length()];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp3(s, 0, t, 0);
    }

    /**
     * 解法一：视角一（站在 t 的角度）进行穷举（递归）
     * 输入：s = "rabbbit", t = "rabbit"
     * 输出：3
     *
     * @param s
     * @param i
     * @param t
     * @param j
     * @return 出现的次数
     */
    public static int dp1(String s, int i, String t, int j) {
        // base case 1：全满足情况，则返回1
        if (t.length() == j) {
            //  t 已全部匹配完成
            return 1;
        }
        // base case 2：绝对不满足情况，则返回0
        if (s.length() - i < t.length() - j) {
            // s[i..] 比 t[j..] 还短，必然无匹配的子序列
            return 0;
        }
        int res = 0;
        // 在 s[i..] 中寻找 k，使得 s[k] == t[j]
        for (int k = i; k < s.length(); k++) {
            if (s.charAt(k) == t.charAt(j)) {
                // 累加结果
                res += dp1(s, k + 1, t, j + 1);
            }
        }
        return res;
    }

    private static int[][] memo;

    /**
     * 解法二：视角一（站在 t 的角度）带备忘录的进行穷举（递归）
     * 输入：s = "rabbbit", t = "rabbit"
     * 输出：3
     *
     * @param s
     * @param i
     * @param t
     * @param j
     * @return 出现的次数
     */
    public static int dp2(String s, int i, String t, int j) {
        // base case 1：全满足情况，则返回1
        if (t.length() == j) {
            //  t 已全部匹配完成
            return 1;
        }
        // base case 2：绝对不满足情况，则返回0
        if (s.length() - i < t.length() - j) {
            // s[i..] 比 t[j..] 还短，必然无匹配的子序列
            return 0;
        }
        // 查备忘录防止冗余计算
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int res = 0;
        // 在 s[i..] 中寻找 k，使得 s[k] == t[j]
        for (int k = i; k < s.length(); k++) {
            if (s.charAt(k) == t.charAt(j)) {
                // 累加结果
                res += dp2(s, k + 1, t, j + 1);
            }
        }
        memo[i][j] = res;
        return res;
    }


    /**
     * 解法三：视角二（站在 s 的角度）带备忘录的进行穷举（递归）
     * 输入：s = "rabbbit", t = "rabbit"
     * 输出：3
     *
     * @param s
     * @param i
     * @param t
     * @param j
     * @return 出现的次数
     */
    public static int dp3(String s, int i, String t, int j) {
        // base case 1：全满足情况，则返回1
        if (t.length() == j) {
            //  t 已全部匹配完成
            return 1;
        }
        // base case 2：绝对不满足情况，则返回0
        if (s.length() - i < t.length() - j) {
            // s[i..] 比 t[j..] 还短，必然无匹配的子序列
            return 0;
        }
        // 查备忘录防止冗余计算
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int res = 0;
        // 在 s[i] 是否等于 t[j]
        if (s.charAt(i) == t.charAt(j)) {
            /**
             * ■ 情况一：让 s[0] 匹配 t[0]，则原问题转化为在 s[1..] 的所有子序列中计算 t[1..] 出现的次数。
             * ■ 情况二：不让 s[0] 匹配 t[0]，则原问题转化为在 s[1..] 的所有子序列中计算 t[0..] 出现的次数。
             */
            res += dp3(s, i + 1, t, j + 1) + dp3(s, i + 1, t, j);
        } else {
            // 如果不匹配，则原问题可转化为计算 s[1..] 的所有子序列中 t[0..] 出现的次数。
            res += dp3(s, i + 1, t, j);
        }
        memo[i][j] = res;
        return res;
    }
}
