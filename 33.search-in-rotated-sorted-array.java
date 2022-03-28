/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        // ローテーションの切れ目を見つける
        if (nums[0] > nums[nums.length - 1]) {
            int left = 0;
            int right = nums.length - 1;
            // ローテーションあり
            while (left < right-1) {
                int center = left + (right - left) /2;
                if (nums[center] > nums[right]) {
                    left = center;
                } else {
                    right = center;
                }
            }
            int low_left = 0;
            int low_right = left;
            int high_left = right;
            int high_right = nums.length -1;
            // targetがどちらの区間に存在するか確認しつつ、もう一度二分探索を行う
            if (nums[low_left] <= target && target <= nums[low_right]) {
                while (low_left < low_right -1) {
                    int low_center = low_left + (low_right - low_left) /2;
                    if (nums[low_center] < target) {
                        low_left = low_center;
                    } else {
                        low_right = low_center;
                    }
                }
                if (nums[low_left] == target) {
                    return low_left;
                } else if (nums[low_right] == target) {
                    return low_right;
                } else {
                    return -1;
                }
            } else if (nums[high_left] <= target && target <= nums[high_right]) {
                while (high_left < high_right - 1) {
                    int high_center = high_left + (high_right - high_left) /2;
                    if (nums[high_center] < target) {
                        high_left = high_center;
                    } else {
                        high_right = high_center;
                    }
                }
                if (nums[high_left] == target) {
                    return high_left;
                } else if (nums[high_right] == target) {
                    return high_right;
                } else {
                    return -1;
                }
            } else {
                // 存在し得ないので-1を返す
                return -1;
            }
        } else {
            // ローテーションなしなので普通の二分探索を行う
            int left = 0;
            int right = nums.length - 1;
            while (left < right- 1) {
                int center = left + (right - left)/2;
                if (nums[center] < target) {
                    left = center;
                } else {
                    right = center;
                }
            }
            if (nums[left] == target) {
                return left;
            } else if (nums[right] == target) {
                return right;
            } else {
                return -1;
            }
        }
    }
}
// @lc code=end

