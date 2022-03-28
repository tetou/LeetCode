/*
 * @lc app=leetcode id=240 lang=java
 *
 * [240] Search a 2D Matrix II
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        // 1行ずつ読んでいって、二分探索で探していく
        // O(m * log(n)) または O(n * log(m))
        // centerがわかったら、実はtargetはそのcenterよりも左側にあることが確定する
        int right_tmp = 0;
        for (int i = 0; i < m; i++) {
            int left = 0;
            int right = (i==0) ? n-1 : right_tmp;
            while (left < right - 1) {
                int center = left + (right - left) / 2;
                if (matrix[i][center] < target) {
                    left = center;
                } else {
                    right = center;
                }
            }
            if (matrix[i][left] == target || matrix[i][right] == target) {
                return true;
           }

           right_tmp = right;
        }
        return false;
    }
}
// @lc code=end

