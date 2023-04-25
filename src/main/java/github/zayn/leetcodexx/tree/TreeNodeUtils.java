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
        if(value == null){
            return null;
        }
        TreeNode node = new TreeNode(value);
        node.left = createTreeNode(arr, index * 2);
        node.right = createTreeNode(arr, index * 2 + 1);
        return node;
    }
    
}
