package github.zayn.leetcodexx.tree;

/**
 * @ClassName Leetcode101
 * @DESCRIPTION 对称二叉树
 * @Author zhangjiayi07
 * @Date 2023/5/18 9:03 PM
 **/
public class Leetcode101 {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return (right.val == left.val && isMirror(left.left, right.right) && isMirror(left.right, right.left));
    }

    private boolean isMirrorV2(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return  (t1.val == t2.val && isMirrorV2(t1.left, t2.right) && isMirrorV2(t1.right, t2.left));
    }
}
