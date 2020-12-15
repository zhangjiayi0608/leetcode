package github.zayn.leetcodexx.tree.leetcode94;

import java.util.ArrayList;
import java.util.List;


/**
 * leetcode94
 */
public class PostorderTravelBinaryTree {
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

    public static void main(String[] args) {
        Integer[] a={1,null,2,3};
    }
}
