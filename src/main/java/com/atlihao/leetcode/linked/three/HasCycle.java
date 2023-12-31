package com.atlihao.leetcode.linked.three;

/**
 * @author lihao
 * @ClassName HasCycle
 * @Since 2020/2/23
 * @Description 141、环形链表
 * https://leetcode.cn/problems/linked-list-cycle/
 * 说明：给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 */
public class HasCycle {

    /**
     * 解法：快慢指针法
     * 时间复杂度：O(n)
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return Boolean.FALSE;
        }
        ListNode slowNode = head;
        ListNode fastNode = head.next;
        //校验是否到尾结点
        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (slowNode == fastNode) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
