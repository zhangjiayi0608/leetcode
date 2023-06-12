package github.zayn.leetcodexx.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * leetcode94
 * 递归二叉树
 */
public class Leetcode94TravelBinaryTree {
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
//--------------------------------------分割线---------------------------------------------
    
    //前序递归
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorderRes = new ArrayList<>();
        preOrderHelper(root,preorderRes);
        return preorderRes;
    }
    public void preOrderHelper(TreeNode root, List<Integer>preorderRes){
        if (root != null) {
            preorderRes.add(root.val);
            if (root.left != null) {
                preOrderHelper(root.left,preorderRes);
            }
            if (root.right!=null){
                preOrderHelper(root.right,preorderRes);
            }
        }
    }
    
    
//--------------------------------------分割线---------------------------------------------


    /**
     * 递归后序二叉树
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorderRes = new ArrayList<>();
        postorderhelper(root, postorderRes);
        return postorderRes;
    }

    public void postorderhelper(TreeNode root, List<Integer> postorderRes) {
        if (root != null) {
            if (root.left != null) {
                postorderhelper(root.left, postorderRes);
            }
            if (root.right != null) {
                postorderhelper(root.right, postorderRes);
            }
            postorderRes.add(root.val);
        }
    }
}
