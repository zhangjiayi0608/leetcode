package github.zayn.leetcodexx.tree;

/**
 * @ClassName TreeNodeUtils
 * @DESCRIPTION TODO
 * @Author zhangjiayi07
 * @Date 2023/4/24 8:36 PM
 **/
public class TreeNodeUtils {
    public static TreeNode createTreeNode(Integer[] arr) {
        return createTreeNode(arr, 1);
    }

    public static TreeNode createTreeNode(Integer[] arr, int index) {
        if (index > arr.length) {
            return null;
        }
        Integer value = arr[index - 1];
        if (value == null) {
            return null;
        }
        TreeNode node = new TreeNode(value);
        node.left = createTreeNode(arr, index * 2);
        node.right = createTreeNode(arr, index * 2 + 1);
        return node;
    }

    public static Integer[] tree2Arr(TreeNode root) {
        Integer[] result = new Integer[1000];
        preOrder(root, result, 1);
        return result;
    }

    private static void preOrder(TreeNode root, Integer[] arr, int index) {
        if (root != null) {
            arr[index - 1] = root.val;
            if (root.left != null) {
                preOrder(root.left, arr, ++index);
            }
            if (root.right != null) {
                preOrder(root.right, arr, ++index);
            }
        } else {
            arr[index - 1] = null;
            ++index;
        }
    }


}
