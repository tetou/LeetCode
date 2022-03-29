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
            for (int j = i; j < n; j++) {
                int min = Integer.MAX_VALUE; 
                for (int k = i; k <= j; k++) {
                    min = Math.min(min, heights[k]);
                }
                result = Math.max(result, min * (j-i+1));
            }
        }
        return result;
    }
}
// @lc code=end

