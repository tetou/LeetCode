/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    /**
     * 左右それぞれで水が溜まる可能性があるエリアを図示して、
     * その２つのうち最小の方が、実際に水が溜まるエリア、と考える
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int n = height.length;

        int[] from_left_height = new int[n];
        int[] from_right_height = new int[n];

        int cur = 0;
        for (int i = 0; i < n; i++) {
            int h = height[i];
            cur = Math.max(cur, h);
            from_left_height[i] = cur;
        }

        cur = 0;
        for (int i = 0; i < n; i++) {
            int h = height[n-i-1];
            cur = Math.max(cur, h);
            from_right_height[i] = cur;
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += Math.min(from_left_height[i], from_right_height[n-i-1]) - height[i];
        }

        return result;
    }
}
// @lc code=end

