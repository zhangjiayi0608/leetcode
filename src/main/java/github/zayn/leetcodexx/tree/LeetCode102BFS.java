package github.zayn.leetcodexx.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * leetCode 102
 * 二叉树的层次遍历
 */
public class LeetCode102BFS {
    /**
     * 递归
     */

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        if (root == null) {
            return levels;
        }
        helper(root, 0, levels);
        return levels;
    }

    private void helper(TreeNode node, int level, List<List<Integer>> levels) {
        if (level == levels.size()) {
            levels.add(new ArrayList<>());
        }
        levels.get(level).add(node.val);
        if (node.left != null) {
            helper(node.left, level + 1, levels);
        }
        if (node.right != null) {
            helper(node.right, level + 1, levels);
        }
    }


    /**
     * 用栈
     *
     * @param
     */
    public List<List<Integer>> levelOrderV2(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        if (root == null) {
            return levels;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode pop = queue.poll();
                level.add(pop.val);
                if (pop.left != null) {
                    queue.add(pop.left);
                }
                if (pop.right != null) {
                    queue.add(pop.right);
                }
            }
            levels.add(level);
        }

        return levels;
    }


    public static void main(String[] args) {
        Integer[] a = {3, 9, 20, null, null, 15, 7};
        TreeNode treeNode = TreeNodeUtils.createTreeNode(a);
        LeetCode102BFS leetCode102Bfs = new LeetCode102BFS();
        List<List<Integer>> lists = leetCode102Bfs.levelOrderV2(treeNode);
        System.out.println();
    }

}
