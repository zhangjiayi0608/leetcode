package github.zayn.leetcodexx.tree.leetcode226;

/**
 * 创建二叉树
 */
public class BinaryTree {
    public TreeNode root = null;

    public BinaryTree(Integer[] array, int index) {
        root = createBinaryTree(array, index);
    }

    // 创建二叉树
    private TreeNode createBinaryTree(Integer[] array, int index) {

        TreeNode treeNode = null;
        if (index < array.length) {
            treeNode = new TreeNode(array[index]);
            // 对于顺序存储的完全二叉树，如果某个节点的索引为index，其对应的左子树的索引为2*index+1，右子树为2*index+1
            treeNode.left = createBinaryTree(array, 2 * index + 1);
            treeNode.right = createBinaryTree(array, 2 * index + 2);
        }
        return treeNode;

    }

    public static void main(String[] args) {
        Integer[] a = {1, 1, 2, 3};
        BinaryTree createBinaryTree = new BinaryTree(a, 0);
        System.out.println(createBinaryTree);
    }

}
