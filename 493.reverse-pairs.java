/*
 * @lc app=leetcode id=493 lang=java
 *
 * [493] Reverse Pairs
 */

// @lc code=start
class Solution {
    public int reversePairs(int[] nums) {
        // ブルートフォース解を書いて、TLEさせる
        int n = nums.length;

        int result = 0;
        for (int i = 0; i < n-1; i++)  {
            for (int j = i+1; j < n; j++) {
                if ((long)nums[i] > (long)2 * nums[j]) result++;
            }
        }

        return result;
    }
}
// @lc code=end

