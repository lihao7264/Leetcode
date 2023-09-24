package com.atlihao.leetcode.tree.one;

import java.util.Stack;

/**
 * @Description: 判断二叉树是否对称
 * @Author: lihao7264
 * @CreateDate: 2021/11/17 10:53 下午
 * @UpdateUser: lihao7264
 * @UpdateDate: 2021/11/17 10:53 下午
 * @Version: 1.0.0
 */
public class SymmetricTree {
    public class TreeNode {
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

    public boolean isSymmetric(TreeNode root) {
        return isSymmetricTreeIterative(root);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (right != null && left != null) {
            return right.val == left.val &&
                    isSymmetric(left.left, right.right) &&
                    isSymmetric(right.left, left.right);
        } else {
            return left == null && right == null;
        }
    }

    /**
     * 递归方式
     * Time(时间复杂度)：O(n)、Space(空间复杂度):O(n)
     *
     * @param root
     * @return
     */
    public boolean isSymmetricTreeRecursive(TreeNode root) {
        if (root == null) {
            return Boolean.TRUE;
        }
        return isSymmetric(root.left, root.right);
    }

    /**
     * 迭代方式
     * Time(时间复杂度)：O(n)、Space(空间复杂度):O(1)
     *
     * @param root
     * @return
     */
    public boolean isSymmetricTreeIterative(TreeNode root) {
        if (root == null) {
            return Boolean.TRUE;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.empty()) {
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();
            // 节点都为空的话，则跳过
            if (right == null && left == null) {
                continue;
            }
            // 如果一个为空，一个非空的话，则直接不对称
            if (right == null || left == null) {
                return Boolean.FALSE;
            }
            if (right.val != left.val) {
                return Boolean.FALSE;
            }
            stack.push(left.left);
            stack.push(right.right);
            stack.push(right.left);
            stack.push(left.right);
        }
        return Boolean.TRUE;
    }

}


