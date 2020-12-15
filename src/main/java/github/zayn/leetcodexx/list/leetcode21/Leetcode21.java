package github.zayn.leetcodexx.list.leetcode21;

/**
 * 合并两个可用链表
 */
public class Leetcode21 {

    /**
     * 递归合并
     *
     * @param list1
     * @param list2
     * @return
     */
    public Node merge1(Node list1, Node list2) {
        if (list1.data < list2.data) {
            list1.next = merge1(list1.next, list2);
            return list1;
        } else if (list2.data < list1.data) {
            list2.next = merge1(list1, list2.next);
            return list2;
        } else if (list1 == null) {
            return list2;
        } else {
            return list1;
        }
    }

    /**
     * 迭代
     */
    public Node merge2(Node l1, Node l2) {
        //new个新的链表存储
        Node pre = new Node(-1);
        //一个指针指向链表
        Node prev = pre;
        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        if (l1 == null) {
            prev.next = l2;
        }
        if (l2 == null) {
            prev.next = l1;
        }
        return pre.next;
    }

}
