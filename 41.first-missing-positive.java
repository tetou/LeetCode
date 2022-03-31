/*
 * @lc app=leetcode id=41 lang=java
 *
 * [41] First Missing Positive
 */

// @lc code=start
class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        // numsの右以上にあるか、中にあるか、左にあるか・・・
        int n = nums.length;

        if (nums[n-1] <= 0) return 1;
        if (nums[0] > 1) return 1;

        int result = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                continue;
            }                
            if (nums[i] != result) {
                return result;
            }
            if (i < n-1 && nums[i] != nums[i+1]) result++;
        }
        return result+1;
    }
}
// @lc code=end

