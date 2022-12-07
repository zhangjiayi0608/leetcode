package github.zayn.leetcodexx.backtrack.leetcode51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName NQueen
 * @DESCRIPTION TODO
 * @Author zhangjiayi07
 * @Date 2021/7/8 8:46 下午
 **/
public class NQueen {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> resultList = new ArrayList<>();
        int[] queens = new int[n];
        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagonals1 = new HashSet<>();
        Set<Integer> diagonals2 = new HashSet<>();
        backtrack(resultList, queens, n, 0, columns, diagonals1, diagonals2);
        return resultList;
    }

    public void backtrack(List<List<String>> resultList, int[] queens, int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (row == n) {
            List<String> board = generateBoard(queens, n);
            resultList.add(board);
        } else {
            for (int i = 0; i < n; i++) {
                if (columns.contains(i)) {
                    continue;
                }
                int diagonal1 = row - i;
                if (diagonals1.contains(diagonal1)) {
                    continue;
                }
                int diagonal2 = row + i;
                if (diagonals2.contains(diagonal2)) {
                    continue;
                }
                queens[row] = i;
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                backtrack(resultList, queens, n, row + 1, columns, diagonals1, diagonals2);
                queens[row] = -1;
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
        }
    }

    public List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }

    public static void main(String[] args) {
        NQueen queen = new NQueen();
        List<List<String>> nQueens = queen.solveNQueens(4);
        System.out.println(nQueens);
    }
}
