package github.zayn.leetcodexx.list.leetcode206;


public class MyLinkedList {
    Node head = null;

    /**
     * 添加链表节点
     *
     * @param d
     */
    public void addNode(int d) {
        Node newNode = new Node(d);
        if (head == null) {
            head = newNode;
            return;
        }
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = newNode;
    }


    /**
     * 删除链表节点
     *
     * @param index
     * @return
     */
    public boolean deleteNode(int index) {
        if (index < 1 || index > length()) {
            return false;
        }
        if (index == 1) {
            head = head.next;
            return true;
        } else {
            int i = 2;
            Node preNode = head;
            Node curNode = preNode.next;
            while (curNode != null) {
                if (i == index) {
                    preNode.next = curNode.next;
                    return true;
                }
                preNode = curNode;
                curNode = curNode.next;
            }
            return true;
        }
    }

    /**
     * 获取链表长度
     *
     * @return
     */
    public int length() {
        int length = 0;
        Node tmp = head;
        while (tmp != null) {
            length++;
            tmp = tmp.next;
        }
        return length;
    }

    /**
     * 链表排序
     *
     * @param list
     */
    public void orderList(MyLinkedList list) {


    }

    /**
     * 反转链表
     */
    public Node reverseListByRecursion(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node bigNode = head.next;
        Node node = reverseListByRecursion(bigNode);
        bigNode.next = head;
        head.next = null;
        return node;
    }

    public Node reverseList(Node head) {
        Node preNode = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = preNode;
            preNode = head;
            head = next;
        }
        return preNode;
    }

    /**
     * 反转部分链表
     */
    public Node reverseList(Node head, int m, int n) {
        Node pre = new Node(0);
        pre.next = head;
        Node p = pre;
        Node q = pre.next;
        for (int i = 0; i < m; i++) {
            p = p.next;
            q = q.next;
        }
        for (int j = 0; j < n - m; j++) {
            Node removed = p.next;
            p.next = p.next.next;
            removed.next = q.next;
            q.next = removed;
        }

        return pre.next;
    }

    /**
     * 删除无头链表的一个节点
     *
     * @param currentNode
     */
    public void deleteRandomNode(Node currentNode) {
        Node nextNode = currentNode.next;
        if (nextNode != null) {
            //把后面节点的值给当前节点
            currentNode.data = nextNode.data;
            //越过下一节点
            currentNode.next = nextNode.next;
        }
        nextNode = null;
    }

    /**
     * 找到环链表的起始点
     *
     * @param list
     * @return
     */
    public Node EntryNodeOfLoop(Node list) {
        Node fast = list;
        Node slow = list;
        while (fast != slow) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = list;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }


    public static void main(String[] args) {
        MyLinkedList list1 = new MyLinkedList();
        list1.addNode(1);
        list1.addNode(2);
        list1.addNode(3);

    }
}


