package com.atlihao.leetcode.tree.two;

import java.util.Stack;

/**
 * @Description: 判断两个二叉树是否相同
 * @Author: lihao7264
 * @CreateDate: 2021/11/21 10:59 下午
 * @UpdateUser: lihao7264
 * @UpdateDate: 2021/11/21 10:59 下午
 * @Version: 1.0.0
 */
public class SameTreeSolution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSameTreeIterative(p, q);
    }

    /**
     * 递归方式
     * Time(时间复杂度)：O(n)、Space(空间复杂度):O(n)
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTreeRecursive(TreeNode p, TreeNode q) {
        if (p == null && q == null) {// 递归终止条件
            return Boolean.TRUE;
        }
        if (p == null || q == null) {
            return Boolean.FALSE;
        }
        return p.val == q.val &&
                isSameTreeRecursive(p.left, q.left) &&
                isSameTreeRecursive(p.right, q.right);
    }

    /**
     * 迭代方式
     * Time(时间复杂度)：O(n)、Space(空间复杂度):O(n)
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTreeIterative(TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(p);
        stack.push(q);
        while (!stack.empty()) {
            TreeNode s = stack.pop();
            TreeNode t = stack.pop();
            if (s == null && t == null) {
                continue;
            }
            if (s == null || t == null) {
                return Boolean.FALSE;
            }
            if (s.val != t.val) {
                return Boolean.FALSE;
            }
            stack.push(s.left);
            stack.push(t.left);
            stack.push(s.right);
            stack.push(t.right);
        }
        return Boolean.TRUE;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
