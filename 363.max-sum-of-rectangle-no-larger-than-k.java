/*
 * @lc app=leetcode id=363 lang=java
 *
 * [363] Max Sum of Rectangle No Larger Than K
 */

// @lc code=start
class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        // 一度計算したものを再利用することが可能なはず
        // 0,0 - i,j までの合計値を保存する配列
        int[][] dp = new int[m][n];
        dp[0][0] = matrix[0][0];
        // １行目
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j-1] + matrix[0][j];
        }
        // １列目
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0] + matrix[i][0];
        }
        // ２行目、２列目以降については、0,0から始まる長方形の足し引きでなんとか求められる。
        for (int i = 1; i < m;i++) {
            for (int j = 1;j < n; j++) {
                dp[i][j] = matrix[i][j] + dp[i][j-1] + dp[i-1][j] - dp[i-1][j-1];
            }
        }

        /** ちゃんと計算できていそうかを確認する */
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j]);
            }
            System.out.println("");
        }

        return 0;
    }
}
// @lc code=end

