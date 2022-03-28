/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 */

// @lc code=start
class Solution {
    // 文字列がwordと一致したらカウント
    private int result = 0;
    private int m;
    private int n;
    private String target;

    public boolean exist(char[][] board, String word) {
        this.target = word;
        this.m = board.length;
        this.n = board[0].length;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                help(i, j, board, "");
            }
        }
        return result > 0;
    }

    private void help(int row, int col, char[][] board, String word) {

        String current = word + String.valueOf(board[row][col]);

        if (current.equals(target)) {
            result++;
            return;
        } else if (!target.contains(current)) {
            return;
        }

        // 読み込み済マーク
        char backup = board[row][col];
        board[row][col] = '0';

        if (row > 0) {
            help(row-1, col, board, current);
        }
        if (row < m-1) {
            help(row+1, col, board, current);
        }
        if (col > 0) {
            help(row, col-1, board, current);
        }
        if (col < n - 1) {
            help(row, col+1, board, current);
        }

        // 読み込み解除
        board[row][col] = backup;
    }
}
// @lc code=end

