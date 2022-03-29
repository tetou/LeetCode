/*
 * @lc app=leetcode id=64 lang=java
 *
 * [64] Minimum Path Sum
 */

// @lc code=start
class Solution {
    private int result = Integer.MAX_VALUE;
    private int m,n;
    private int[][] grid;

    public int minPathSum(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.grid = grid;

        help(0,0,0,new ArrayList<Integer>());

        return result;
    }

    private void help(int row, int col, int sum, List<Integer> list) {
        list.add(grid[row][col]);
        sum += grid[row][col];

        // 最小を超えていたら検索しなくて良い
        if (sum > result) return;

        if (list.size() == m+n-1) {
            result = Math.min(result, sum);
            return;
        }

        if (row < m-1) {
            List<Integer> list1 = new ArrayList<>(list);
            help(row+1,col,sum,list1);
        }
        if (col < n-1) {
            List<Integer> list2 = new ArrayList<>(list);
            help(row,col+1,sum, list2);
        }
    }
}
// @lc code=end

