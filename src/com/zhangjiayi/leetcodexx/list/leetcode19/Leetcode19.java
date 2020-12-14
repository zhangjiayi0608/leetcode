package com.zhangjiayi.leetcodexx.list.leetcode19;

import java.util.List;

/**
 * 两个指针，一个先走n步，然后两个指针一起走，先走的走n步，然后一起走，start走到头，后走的end.next = end.next.next;就行
 */
public class Leetcode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode start = pre, end = pre;
        while (n != 0) {
            start = start.next;
            n--;
        }
        while (start.next != null) {
            start = start.next;
            end = end.next;
        }
        end.next = end.next.next;
        return pre.next;
    }

}
