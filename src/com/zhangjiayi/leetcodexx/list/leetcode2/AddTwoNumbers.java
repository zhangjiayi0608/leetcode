package com.zhangjiayi.leetcodexx.list.leetcode2;


import com.zhangjiayi.Main;

/**
 * leetcode 2
 */
public class AddTwoNumbers {
    public Node addTwoNumbers(Node l1, Node l2) {
        //预先指针
        Node pre = new Node(0);
        Node p = l1, q = l2, curr = pre;
        int carry = 0;
        while (p != null || q != null) {
            int x = p != null ? p.data : 0;
            int y = q != null ? q.data : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new Node(sum % 10);
            curr = curr.next;
            if (p.next != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (carry > 0) {
            curr.next = new Node(carry);
        }
        return pre.next;
    }


    public Node addTwoNums(Node l1, Node l2) {
        int carry = 0;
        Node curr = new Node(0);
        Node p = l1, q = l2;
        while (p != null || q != null) {
            int x = p != null ? p.data : 0;
            int y = q != null ? q.data : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.data = sum % 10;
            curr=curr.next;
            if (p.next != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (carry > 0) {
            curr.next = new Node(carry);

        }
        return curr.next;
    }

    public static void main(String[] args) {

    }
}
