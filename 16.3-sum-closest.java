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
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int n = nums.length;
        int result = 0;
        for (int i = 0; i < n - 2;i++) {
            int left = i+1;
            int right = n-1;
            while (left < right) {
                int total = nums[i]+nums[left]+nums[right];
                if (total < target) {
                    if (diff > target-total) {
                        result = total;
                        diff = target-total;
                    }
                    left++;
                } else if (total > target) {
                    if (diff > total - target) {
                        result = total;
                        diff = total - target;
                    }
                    right--;
                } else {
                    // ピタリ賞なので、これで終了
                    System.out.println("pitari");
                    return target;
                }
            }
        }
        return result;
    }
}
// @lc code=end

