package github.zayn.leetcodexx.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


/**
 * leetcode226
 */
public class Leetcode226InvertBinaryTree {
    public TreeNode invertTreeByStack(TreeNode root) {
        if (root == null) {
            return root;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            final TreeNode node = stack.pop();
            final TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return root;
    }

    public TreeNode invertTreeByQueue(TreeNode root) {
        if (root == null) {
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            final TreeNode node = queue.poll();
            final TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }

    public TreeNode invertTreeByRecursion(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTreeByRecursion(root.left);
        invertTreeByRecursion(root.right);
        return root;
    }

    public TreeNode invertTree(TreeNode root){
        if (root==null){
            return root;
        }
        TreeNode left=root.left;
        root.left=root.right;
        root.right=left;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
