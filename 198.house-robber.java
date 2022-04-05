/*
 * @lc app=leetcode id=198 lang=java
 *
 * [198] House Robber
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        // dp[i] : インデックスiまでに得られるお金の最大値
        int N = nums.length;
        if (N == 1) return nums[0];
        int[] dp = new int[N];       
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        if (N == 2) return dp[1];
        for (int i = 2; i < N; i++) {
            // i で強奪しない、または強奪した場合のうちの最大
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[N-1];
    }
}
// @lc code=end

