package github.zayn.leetcodexx.tree;

/**
 * @ClassName BinaryTree
 * @DESCRIPTION TODO
 * @Author zhangjiayi07
 * @Date 2023/4/25 8:04 PM
 **/
public class BinarySearchTree {
    private TreeNode tree;

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
        TreeNode p = tree;
        while (p != null) {
            if (data > p.val) {
                if (p.right == null) {
                    p.right = new TreeNode(data);
                    return;
                }
                //去右边
                p = p.right;
            } else {
                if (data < p.val) {
                    if (p.left == null) {
                        p.left = new TreeNode(data);
                        return;
                    }
                }
                //去左边
                p = p.left;
            }
        }
    }

    public void delete(int data) {
        //p最终指向被删除的节点
        TreeNode p = tree;
        //pp最终指向被删除的节点的父节点
        TreeNode pp = null;
        //找p
        while (p != null && p.val != data) {
            pp = p;
            if (data > p.val) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        //如果p下面有两个节点
        if (p.left != null && p.right != null) {
            //寻找p右边下面的最小值
            TreeNode minP = p.right;
            TreeNode minPP = p;
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            //之后把minP的值替换给p
            p.val = minP.val;
            //然后就相当于删除minP,走下面的删除流程
            p = minP;
            pp = minPP;
        }
        //如果p下面只有一个或者没有节点,就直接把子节点搞过去就行
        TreeNode child;
        if (p.left != null) {
            child = p.left;
        } else if (p.right != null) {
            child = p.right;
        } else {
            child = null;
        }
        if (pp == null) {
            tree = child;
        } else if (pp.left == p) {
            pp.left = child;
        } else {
            pp.right = child;
        }
    }

}