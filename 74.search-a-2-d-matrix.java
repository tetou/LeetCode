/*
 * @lc app=leetcode id=74 lang=java
 *
 * [74] Search a 2D Matrix
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int row = -1;
        // どの行にtargetがあるかを確認する（O(m)）
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] <= target && target <= matrix[i][n-1]) {
                row = i;
                break;
            }
        }
        if (row == -1) return false;
        // 各行はsortされているから、そこで二分探索を行う
        int left = 0;
        int right = n-1;
        while (left < right - 1) {
            int center = left + (right - left) / 2;
            if (matrix[row][center] < target) {
                left = center;
            } else {
                right = center;
            }
        }
        if (matrix[row][left] == target) {
            return true;
        } else if (matrix[row][right] == target) {
            return true;
        } else {
            return false;
        }
    }
}
// @lc code=end

