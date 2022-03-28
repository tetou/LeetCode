/*
 * @lc app=leetcode id=719 lang=java
 *
 * [719] Find K-th Smallest Pair Distance
 */

// @lc code=start
class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();       
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                q.add(Math.abs(nums[i]-nums[j]));
            }
        }
        for (int i = 1; i < k; i++) {
            q.poll();
        }
        return q.peek();
    }
}
// @lc code=end

