/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 */

// @lc code=start
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int result = Integer.MIN_VALUE;
        // Brute force
        for (int i = 0; i < n; i++) {
            int min = heights[i];
            for (int j = i; j < n; j++) {
                min = Math.min(min, heights[j]);
                result = Math.max(result, min * (j-i+1));
            }
        }
        return result;
    }
}
// @lc code=end

