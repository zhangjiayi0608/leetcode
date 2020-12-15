package github.zayn.leetcodexx.tree.leetcode94;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * leetcode94
 */
public class TravelBinaryTree {
    /**
     * 递归中序二叉树
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorderRes = new ArrayList<>();
        inorderhelper(root, inorderRes);
        return inorderRes;
    }

    public void inorderhelper(TreeNode root, List<Integer> inorderRes) {
        if (root != null) {
            if (root.left != null) {
                inorderhelper(root.left, inorderRes);
            }
            inorderRes.add(root.val);
            if (root.right != null) {
                inorderhelper(root.right, inorderRes);
            }
        }
    }

    /**
     * 栈中序二叉树
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalByStack(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorderRes = new ArrayList<>();
        preorderHelper(root,preorderRes);
        return preorderRes;
    }
    public void preorderHelper(TreeNode root,List<Integer>preorderRes){
        if (root != null) {
            preorderRes.add(root.val);
            if (root.left != null) {
                preorderHelper(root.left,preorderRes);
            }
            if (root.right!=null){
                preorderHelper(root.right,preorderRes);
            }
        }
    }
}
