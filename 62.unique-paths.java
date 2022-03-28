/*
 * @lc app=leetcode id=62 lang=java
 *
 * [62] Unique Paths
 */

// @lc code=start
class Solution {
    public int uniquePaths(int m, int n) {
        // i,jにたどり着くまでのパタン数
        int[][] numPath = new int[m][n];
        for (int j = 0; j < n; j++) {
            numPath[0][j] = 1;
        }
        for (int i = 0; i < m; i++) {
            numPath[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // ひとつ上からくるパタンとひとつ左からくるパタンがある
                numPath[i][j] = numPath[i-1][j] + numPath[i][j-1];
            }
        }

        return numPath[m-1][n-1];
    }
}
// @lc code=end

