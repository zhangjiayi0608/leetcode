package github.zayn.leetcodexx.list.leetcode25;

/**
 * K 个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 示例:
 * <p>
 * 给定这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 * 说明:
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class Leetcode25 {
    public Node reverseKGroup(Node head, int k) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node pre = dummy;
        Node end = dummy;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            //存一下下一组的开始节点，否则会丢失
            Node next = end.next;
            //开始翻转的节点
            Node start = pre.next;
            //断开这组的链表
            end.next = null;
            //翻转列表
            pre.next = reverse(start);
            //重新连接后面的链表
            start.next = next;
            //将pre换成下次要翻转的链表的头结点的上一个节点。即start
            pre = start;
            //翻转结束，将end置为下次要翻转的链表的头结点的上一个节点。即start
            end = start;
        }
        return dummy.next;
    }

    private Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node pre = null;
        Node curr = head;
        Node next = null;
        while (curr != null) {
            //先记录一下下一个节点
            next = curr.next;
            //翻转
            curr.next = pre;
            //向后走
            pre = curr;
            curr = next;
        }
        return pre;
    }

}
