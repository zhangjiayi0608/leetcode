package github.zayn.leetcodexx.eightqueens;

/**
 * @ClassName EightQueens
 * @DESCRIPTION TODO
 * @Author zhangjiayi07
 * @Date 2023/5/17 5:40 PM
 **/
public class EightQueens {
    public static void main(String[] args) {
        int[] result = new int[8];
        eightQueens(0, result);
    }

    public static void eightQueens(int row, int[] result) {
        if (row == 8) {
            //如果八个棋子都放好了，就打印结果
            printQueens(result);
            return;
        }
        for (int column = 0; column < 8; column++) {
            if (isOk(row, column, result)) {
                result[row] = column;
                eightQueens(row + 1, result);
            }
        }
    }

    private static boolean isOk(int row, int column, int[] result) {
        int leftUp = column - 1;
        int rightUp = column + 1;
        for (int i = row - 1; i >= 0; i--) {
            if (result[i] == column) return false;//看一下第i行 的column是否有棋子
            if (leftUp >= 0 && result[i] == leftUp) return false;
            if (rightUp >= 0 && result[i] == rightUp) return false;
            leftUp--;
            rightUp++;
        }
        return true;
    }

    private static void printQueens(int[] result) {
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                if (result[row] == column) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
