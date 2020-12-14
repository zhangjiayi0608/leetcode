package com.zhangjiayi.leetcodexx.tree.leetcode102;

import java.util.ArrayList;
import java.util.List;

/**
 * leetCode 102
 * 二叉树的层次遍历
 */
public class BFS {
    /**
     * 递归
     */
    List<List<Integer>> levels = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return levels;
        }
        helper(root, 0);
        return levels;
    }

    private void helper(TreeNode node, int level) {
        if (level == levels.size()) {
            levels.add(new ArrayList<>());
        }
        levels.get(level).add(node.val);
        if (node.left != null) {
            helper(node.left, level + 1);
        }
        if (node.right != null) {
            helper(node.right, level + 1);
        }
    }


    /**
     * 迭代
     *
     * @param args
     */


    public static void main(String[] args) {
        Integer[] a = {1, 1, 2, 3};
        System.out.println();
    }

}
