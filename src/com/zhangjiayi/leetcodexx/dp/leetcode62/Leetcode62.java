package com.zhangjiayi.leetcodexx.dp.leetcode62;

public class Leetcode62 {

    /**
     * leetcode 62 不同路径
     *
     * @param m,n
     * @return
     */

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {

    }

    public int uniquePaths1(int m,int n){
        int[][]dp=new int[m][n];
        for (int i=0;i<m;i++){
            dp[i][0]=1;
        }
        for (int j=0;j<n;j++){
            dp[0][j]=1;
        }
        for (int i=1;i<m;i++){
            for (int j=1;j<m;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

}
