/*
 * @lc app=leetcode id=315 lang=java
 *
 * [315] Count of Smaller Numbers After Self
 */

// @lc code=start
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        // 総当たりの解法（TLEを想定）
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int count = 0;
            for (int j = i+1; j< nums.length; j++) {
                int next = nums[j];
                if (current > next) count++;
            }
            result.add(count);
        }
        return result;
    }
}
// @lc code=end

