package github.zayn.leetcodexx.tree.leetcode95;

import java.util.List;


/**
 * leetcode95
 * 不同的二叉搜索树
 */
public class SerchBinaryTree {
    public List<TreeNode> generateTrees(int n) {
        return null;
    }


    //搜索二叉树(BST)
    public void buildBinarySearchTree(TreeNode node, Integer data) {
        if (data < node.val) {
            if (node.left == null) {
                node.left = new TreeNode(data);
            } else {
                buildBinarySearchTree(node.left, data);
            }
        } else {
            if (node.right == null) {
                node.right = new TreeNode(data);
            } else {
                buildBinarySearchTree(node.right, data);
            }
        }
    }
}
