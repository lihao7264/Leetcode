package com.atlihao.leetcode.linked.two;

/**
 * @author lihao
 * @ClassName ReverseLinkedList
 * @Since 2020/2/20
 * @Description 206. 反转链表
 * https://leetcode.cn/problems/reverse-linked-list/
 * 反转一个单链表。
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        return reverseListIterative(head);
    }

    /**
     * 递归方式
     * Time(时间复杂度)：O(n)、Space(空间复杂度):O(n)
     *
     * @param head
     * @return
     */
    public ListNode reverseListRecursive(ListNode head) {
        // 递归终止条件
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 迭代方式
     * Time(时间复杂度)：O(n)、Space(空间复杂度):O(1)
     *
     * @param head
     * @return
     */
    public ListNode reverseListIterative(ListNode head) {
        ListNode cur = head;
        ListNode prv = null;
        ListNode next = null;
        while (cur != null) {// 当前节点不能为空
            next = cur.next;// 当前节点的下一个节点
            cur.next = prv;// 反转指针
            prv = cur;// 移动下标
            cur = next;
        }
        return prv;
    }

    /**
     * 方法一：递归
     *
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        //链表为空或者链表只有一个节点
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList1(head.next);
        //一层
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 方法二：迭代
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        ListNode newHead = null;
        //（head的next指向newHead，然后newHead指向head，然后head指向head原来的next节点）
        while (head != null) {
            ListNode tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }
        return newHead;
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
