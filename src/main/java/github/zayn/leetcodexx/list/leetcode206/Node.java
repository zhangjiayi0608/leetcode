package github.zayn.leetcodexx.list.leetcode206;

class Node {
    Node next = null;
    int data;

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    //头部插入节点
    //尾部插入节点
    //翻转链表(递归版)
    public static Node reverseList(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        //把后面整体当做一个大节点
        Node bigNode = node.next;
        //递归
        Node result = reverseList(node.next);
        //大节点连接前节点
        bigNode.next = node;
        //前节点连null
        node.next = null;
        return result;
    }

    //翻转列表（迭代版）
    public static Node reverseList2(Node head) {
        Node begin = null;
        Node curr = head;
        Node end;
        while (curr.next != null) {
            //临时节点，暂存当前节点的下一节点，用于后移
            //因为接下来curr.next进行赋值后将会断链
            end = curr.next;
            //链翻转
            curr.next = begin;
            //前指针后移
            begin = curr;
            //当前指针后移
            curr = end;
        }
        return head;
    }

    //合并两个有序链表
    public static Node mergeNode(Node l1, Node l2) {
        //定义新的链表头
        Node newHead = null;
        //设置一个指针
        Node pre = new Node(0);
        //指针指向链表头
        pre.next = newHead;
        //找到一个最小值
        if (l1.data < l2.data) {
            newHead = l1;
            l1 = l1.next;
        } else {
            newHead = l2;
            l2 = l2.next;
        }
        while (l1.next != null || l2.next != null) {
            if (l1.data > l2.data) {
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
        return pre.next;
    }

    //删除链表倒数第k个节点
    public static Node deleteKNode(Node head, int k) {
        Node node1 = head;
        Node node2 = head;
        for (int i = 0; i < k; i++) {
            node1 = node1.next;
        }
        Node prev = null;
        while (node1 != null) {
            prev = node2;
            node2 = node2.next;
            node1 = node1.next;
        }
        if (prev == null) {
            head = head.next;
        } else {
            prev.next = prev.next.next;
        }
        return head;
    }

    //求链表中间节点
    public static Node midNode(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    //链表中环的检测
    public static Boolean isCircle(Node head) {
        Node quick = head.next;
        Node slow = head;
        while (quick != null && quick.next != null) {
            if (quick == slow) {
                return true;
            } else {
                quick = quick.next.next;
                slow = slow.next;
            }
        }
        return false;
    }
}
