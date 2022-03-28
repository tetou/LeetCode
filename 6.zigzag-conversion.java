/*
 * @lc app=leetcode id=6 lang=java
 *
 * [6] Zigzag Conversion
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        // 1 - numRowsまでのインデックスを持つ
        // numRows - 2の緩衝地帯が存在する
        // PAY P ALI S HIR I NG
        // 012 3 456 7 8910 11 1213
        // n n-2, n, n-2,...
        String[] result = new String[numRows];
        Arrays.fill(result, "");
    }
}
// @lc code=end

