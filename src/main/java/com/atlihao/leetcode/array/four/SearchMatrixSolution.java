package com.atlihao.leetcode.array.four;

/**
 * @Description: 搜索二维矩阵 和 搜索二维矩阵 II
 * @Author: lihao7264
 * @CreateDate: 2021/11/19 9:52 下午
 * @UpdateUser: lihao7264
 * @UpdateDate: 2021/11/19 9:52 下午
 * @Version: 1.0.0
 */
public class SearchMatrixSolution {

    public boolean searchMatrix(int[][] matrix, int target) {
        return searchIn2DArray(matrix, target);
    }

    /**
     * 从右上角搜索
     * Time(时间复杂度)：O(m+n)、Space(空间复杂度):O(1)
     *
     * @param matrix
     * @param target
     * @return
     */
    public Boolean searchIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null
                || matrix[0].length == 0) {
            return Boolean.FALSE;
        }
        int m = matrix.length;//纵向长度
        int n = matrix[0].length;//横向长度
        int i = 0;
        int j = n - 1;// 横向最大的下标
        while (i < m && j >= 0) {
            if (target < matrix[i][j]) {
                --j;
            } else if (target > matrix[i][j]) {
                ++i;
            } else {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

}
