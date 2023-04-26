package github.zayn.leetcodexx.tree;

/**
 * @ClassName BinaryTree
 * @DESCRIPTION TODO
 * @Author zhangjiayi07
 * @Date 2023/4/25 8:04 PM
 **/
public class BinarySearchTree {
    private TreeNode tree;

    public void delete(int data) {

    }

    public TreeNode find(int data) {
        TreeNode p = tree;
        while (p != null) {
            if (data > p.val) {
                p = p.right;
            } else if (data < p.val) {
                p = p.left;
            } else {
                return p;
            }
        }
        return null;
    }

    public void insert(int data) {
        if (tree == null) {
            tree = new TreeNode(data);
            return;
        }
        
    }
}
