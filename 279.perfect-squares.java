/*
 * @lc app=leetcode id=279 lang=java
 *
 * [279] Perfect Squares
 */

// @lc code=start
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        // 自分より小さい最大の平方数を探していく
        // 自分より小さい平方数がなくなったら、後は1の組み合わせ
        // 自分より小さい平方数を保存しておけばいい？？
        // 自分自身が平方数であれば、自分自身になる

        for (int i = 1; i <= n; i++) {
            // 平方数だったら自分自身
            if (Math.sqrt(i) == (double)((int)Math.sqrt(i))) {
                dp[i] = i;
            } else {
                // 自分より小さい平方数を入れる
                dp[i] = dp[i-1];
            }
        }

        // dp[n] から始めて個数をカウントする
        // n=7 -> 7-4 = 3 -> 3 - dp[3] ->2 -> 2 - dp[2] -> 1
        // dp[12] -> 12 - dp[12] = 3
        int result = 0;
        int m = n;
        while (m > 0) {
            result++;
            m -= dp[m];
        }

        for (int i = 0; i <=n ; i++) {
            System.out.println(dp[i]);
        }

        return result;
    }
}
// @lc code=end

