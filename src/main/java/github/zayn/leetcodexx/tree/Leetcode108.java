package github.zayn.leetcodexx.tree;

/**
 * @ClassName Leetcode108
 * @DESCRIPTION 将有序数组转换为二叉搜索树
 * <p>
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * <p>
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 * 示例 1：
 * 输入：nums = [-10,-3,0,5,9]
 * 输出：[0,-3,9,-10,null,5]
 * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
 * <p>
 * 示例 2：
 * 输入：nums = [1,3]
 * 输出：[3,1]
 * 解释：[1,null,3] 和 [3,1] 都是高度平衡二叉搜索树。
 * @Author zhangjiayi07
 * @Date 2023/4/25 2:40 PM
 **/
public class Leetcode108 {


    //-----------------分割线-----------------------------------
    //错误的做法，为啥错？因为不是高度平衡的二叉搜索树
    public TreeNode sortedArrayToBST(int[] nums) {
        int size = nums.length;
        //获取有序数组的中间值,把他当做根
        int rootValue = nums[size / 2];
        TreeNode root = new TreeNode(rootValue);
        for (int i = 0; i < size / 2; i++) {
            buildBST(root, nums[i]);
        }
        for (int j = size / 2 + 1; j < size; j++) {
            buildBST(root, nums[j]);
        }
        return root;
    }

    private void buildBST(TreeNode root, int value) {
        if (root.val > value) {
            if (root.left == null) {
                root.left = new TreeNode((value));
            } else {
                buildBST(root.left, value);
            }
        } else {
            if (root.right == null) {
                root.right = new TreeNode(value);
            } else {
                buildBST(root.right, value);
            }
        }
    }
//------------------分割线end-------------------------


    //直接搞中序遍历的二叉搜索树
    public TreeNode sortedArrayToBSTV2(int[] nums) {
        int size = nums.length;
        TreeNode treeNode = buildBSTV2(nums, 0, size - 1);
        return treeNode;
    }

    private TreeNode buildBSTV2(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(mid);
        root.left = buildBSTV2(nums, left, mid - 1);
        root.right = buildBSTV2(nums, mid + 1, right);
        return root;
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 2, 3, 4, 5};
        Leetcode108 leetcode108 = new Leetcode108();
        TreeNode treeNode = leetcode108.sortedArrayToBST(a);
        System.out.println();
    }

}
