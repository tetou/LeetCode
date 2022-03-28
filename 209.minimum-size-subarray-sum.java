/*
 * @lc app=leetcode id=209 lang=java
 *
 * [209] Minimum Size Subarray Sum
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // 累積和をとる
        int n = nums.length;
        int[] aSum = new int[n+1];
        aSum[0] = 0;
        int sum = 0;
        // O(n)
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            aSum[i+1] = sum;
        }

        int result = Integer.MAX_VALUE;
        // O(n^2)
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // target より大きくなるようなjの下限をbinary searchで求めることが可能
                if (aSum[j+1] - aSum[i] >= target) {
                    result = Math.min(result, j-i+1);
                }
            }
        }

        if (result == Integer.MAX_VALUE) {
            return 0;
        } else {
            return result;
        }
    }
}
// @lc code=end

