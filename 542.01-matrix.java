/*
 * @lc app=leetcode id=542 lang=java
 *
 * [542] 01 Matrix
 */

// @lc code=start
class Solution {
    private int[][] mat;
    private int[][] result;
    private int m, n;
    public int[][] updateMatrix(int[][] mat) {
        this.mat = mat;
        this.m = mat.length;
        this.n = mat[0].length;
        this.result = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j<n; j++) {
                result[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                help(i, j, i, j, 0);
            }
        }

        return result;
    }

    private void help(int row, int col, int i, int j, int dist) {
        // すでに0に到達していたらここで終了
        if (mat[i][j] == 0) {
            result[row][col] = Math.min(dist, result[row][col]);
            return;
        }

        // 到達済マーク
        int backup = mat[i][j];
        mat[i][j] = -1;

        if (i > 0) {
            if (mat[i-1][j] != -1) {
                help(row, col, i-1, j, dist + 1);
            }
        }
        if (i < m - 1) {
            if (mat[i+1][j] != -1) {
                help(row, col, i+1, j, dist + 1);
            }
        }
        if (j > 0) {
            if (mat[i][j-1] != -1) {
                help(row, col, i, j-1, dist + 1);
            }
        }
        if (j < n-1){
            if (mat[i][j+1] != -1) {
                help(row, col, i, j+1, dist + 1);
            }
        }

        // 到達済解除
        mat[i][j] = backup;
    }
}
// @lc code=end

