/*
 * @lc app=leetcode id=1155 lang=java
 *
 * [1155] Number of Dice Rolls With Target Sum
 */

// @lc code=start
class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n+1][target+1];
        dp[0][0] = 1;
        // 2,6,2
        // 1+1
        for (int i = 1; i <= n; i++) {
            for (int x = target; x>=0; x--) {
                for (int j = 1; j <= x && j <= k; j++) {
                    // i-1個のダイスで合計がx-jになる場合の数
                    if (dp[i-1][x-j] != 0) {
                        dp[i][x] += dp[i-1][x-j];
                        dp[i][x] %= 1000000007;
                    }
                }
            }
        }
        return dp[n][target];
    }
}
// @lc code=end

