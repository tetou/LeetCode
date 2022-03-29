/*
 * @lc app=leetcode id=63 lang=java
 *
 * [63] Unique Paths II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        // 最初のコマには障害物がなければ到達可能
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        dp[0][0] = 1;
        // 1列目、1行目については石があるところまでは到達可能
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 1 && obstacleGrid[0][j-1] == 0) break;
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1 && obstacleGrid[i-1][0] == 0) break;
            dp[i][0] = 1;
        }
        // 2列目、2行目以降についてはひとつ手前に石がなければ到達は可能
        for (int i = 1; i < m;i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    // 障害物があるところは到達できない
                    dp[i][j] = 0;
                } else {
                    // 上から到達するパタン
                    dp[i][j] += (obstacleGrid[i - 1][j] == 0) ? dp[i-1][j] : 0;
                    // 左から到達するパタン
                    dp[i][j] += (obstacleGrid[i][j-1] == 0) ? dp[i][j-1] : 0;
                }
            }
        }
        return dp[m-1][n-1];
    }
}
// @lc code=end

