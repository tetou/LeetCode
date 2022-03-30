/*
 * @lc app=leetcode id=16 lang=java
 *
 * [16] 3Sum Closest
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // [-1,2,1,-4]
        // [-4,-1,2,1]
        // -3, 2 -> 他の組み合わせとしては、-1,-4
        // [-9,10,4,1,3,8,5]
        // [-9,1,3,4,5,8,10]
        // num[i] + num[j] + num[k] ~ target
        int diff = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < nums.length -2;i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    int sum = nums[i]+nums[j]+nums[k];
                    if (Math.abs(target - sum) < diff) {
                        result = sum;
                        diff = Math.abs(target - sum);
                    }
                }
            }
        }
        return result;
    }
}
// @lc code=end

