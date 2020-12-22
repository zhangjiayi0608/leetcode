package github.zayn.leetcodexx.array.interview29;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Interview29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        int res[] = new int[(right + 1) * (bottom + 1)];
        int k = 0;
        while (true) {
            //left -> right
            for (int i = left; i <= right; i++) {
                res[k++] = matrix[top][i];
            }
            //往下挪一个身位
            if (++top > bottom) {
                break;
            }
            //top -> bottom
            for (int i = top; i <= bottom; i++) {
                res[k++] = matrix[i][right];
            }
            //往左挪一个身位
            if (left > --right) {
                break;
            }
            //right -> left
            for (int i = right; i >= left; i--) {
                res[k++] = matrix[bottom][i];
            }
            //往上挪一个身位
            if (top > --bottom) {
                break;
            }
            //bottom -> top
            for (int i = bottom; i >= top; i--) {
                res[k++] = matrix[i][left];
            }
            //往右挪一个身位
            if (++left > right) {
                break;
            }

        }
        return res;
    }
}
