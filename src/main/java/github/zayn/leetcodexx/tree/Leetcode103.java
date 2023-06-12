package github.zayn.leetcodexx.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * leetCode 103
 * 二叉树的锯齿状层次遍历
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 */
public class Leetcode103 {
    /**
     * 用队列
     * 因为队列是双向链表，所以有个flag控制他头插还是尾插就行
     *
     * @param
     */
    public List<List<Integer>> levelOrderByQueue(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        if (root == null) {
            return levels;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        //控制队列是头插还是尾插
        boolean flag = true;
        while (!queue.isEmpty()) {
            Deque<Integer> level = new LinkedList<>();
            int currentLevelSize = queue.size();
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode pop = queue.pollFirst();
                if (flag) {
                    level.offerLast(pop.val);
                } else {
                    level.offerFirst(pop.val);
                }
                if (pop.left != null) {
                    queue.offerLast(pop.left);
                }
                if (pop.right != null) {
                    queue.offerLast(pop.right);
                }
            }
            flag = !flag;
            levels.add(new ArrayList<>(level));
        }
        return levels;
    }


    public static void main(String[] args) {
        Integer[] a = {3, 9, 20, null, null, 15, 7};
        TreeNode treeNode = TreeNodeUtils.createTreeNode(a);
        Leetcode103 leetCode103 = new Leetcode103();
        List<List<Integer>> lists = leetCode103.levelOrderByQueue(treeNode);
        System.out.println(lists);
    }

}
