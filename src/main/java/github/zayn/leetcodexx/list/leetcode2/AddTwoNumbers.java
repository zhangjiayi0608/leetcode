package github.zayn.leetcodexx.list.leetcode2;


/**
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 * <p>
 * 示例 1：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 * <p>
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddTwoNumbers {
    public Node addTwoNumbers(Node l1, Node l2) {
        //预先指针
        Node pre = new Node(0);
        Node curr = pre;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 != null ? l1.data : 0;
            int y = l2 != null ? l2.data : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new Node(sum % 10);
            curr = curr.next;
            if (l1.next != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            curr.next = new Node(carry);
        }
        return pre.next;
    }

    public static void main(String[] args) {

    }
}
