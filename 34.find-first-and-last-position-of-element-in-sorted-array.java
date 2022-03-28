/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {

        if (nums.length == 0) return new int[]{-1,-1};

        int low_left = 0;
        int high_left = 0;
        int low_right = nums.length - 1;
        int high_right = nums.length - 1;

        int low = -2;
        int high = -1;

        // [5,7,7,7,8,8,8,8,9,9,10]
        // left = 0, right = 10, target = 8
        // 8より小さいインデックスの上限と、8より大きいインデックスの下限を求めれば良い
        // 5,10 -> 5,8 -> 7,8 -> 7が下限の最大とわかる
        // 上記と同じことを8より大きいインデックスの最小を求めるために行う
        while (low_left < low_right - 1) {
            int low_center = low_left + (low_right - low_left) /2;
            if (nums[low_center] < target) {
                low_left = low_center;
            } else {
                low_right = low_center;
            }
        }
        if (nums[low_left] == target) {
            low = low_left;
        } else if (nums[low_right] == target) {
            low = low_right;
        } else {
            low = -1;
        }

        while (high_left < high_right - 1) {
            int high_center = high_left + (high_right - high_left) / 2;
            if (nums[high_center] > target) {
                high_right = high_center;
            } else {
                high_left = high_center;
            }
        }
        if (nums[high_right] == target) {
            high = high_right;
        } else if (nums[high_left] == target) {
            high = high_left;
        } else {
            high = -1;
        }

        int[] result = new int[]{low, high};
        return result;
    }
}
// @lc code=end

