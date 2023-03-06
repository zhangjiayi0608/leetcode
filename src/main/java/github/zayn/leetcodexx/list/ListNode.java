package github.zayn.leetcodexx.list;

public class ListNode {
    int val;
    ListNode next;

    public ListNode(int data) {
        this.val = data;
    }

    public ListNode(int data, ListNode next) {
        this.val = data;
        this.next = next;
    }

    //添加节点
    public void addNode(int i) {
        ListNode node = new ListNode(i);
        if (next == null) {
            next = node;
        } else {
            ListNode temp = next;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    //头部插入节点
    public void addNodeHead(int d) {
        if (next == null) {
            next = new ListNode(d);
        } else {
            ListNode newHead = new ListNode(d);
            newHead.next = next;
            next = newHead;
        }
    }

    //尾部插入节点
    public void insertTail(int value){

        ListNode newNode = new ListNode(value, null);
        //空链表，可以插入新节点作为head，也可以不操作
        if (next == null){
            next = newNode;

        }else{
            ListNode q = next;
            while(q.next != null){
                q = q.next;
            }
            q.next = newNode;
        }
    }
    //翻转链表(递归版)
    public ListNode reverseList(ListNode node) {
        if (node == null || node.next == null) {
            return null;
        }
        ListNode bigNode = node.next;
        ListNode result = reverseList(node.next);
        bigNode.next = node;
        node.next = null;
        return result;
    }

    //翻转列表（迭代版）
    public ListNode reverseList2(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;
        ListNode next;
        while (node.next != null) {
            next = curr.next;
            node.next = prev;
            prev = curr;
            curr = next;
        }
        return node;
    }

    //合并两个有序链表
    public ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode newHead = null;
        prev.next = newHead;
        if (l1.val > l2.val) {
            newHead = l2;
            l2.next = l2;
        } else {
            newHead = l1;
            l1.next = l1;
        }
        while (l1.next != null || l2.next != null) {
            if (l1.val > l2.val) {
                newHead.next = l2;
                l2 = l2.next;
            } else {
                newHead.next = l1;
                l1 = l1.next;
            }
            newHead = newHead.next;
        }
        if (l1 != null) {
            newHead.next = l1;
        }
        if (l2 != null) {
            newHead.next = l2;
        }
        return prev.next;
    }
}
