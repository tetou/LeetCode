/*
 * @lc app=leetcode id=474 lang=java
 *
 * [474] Ones and Zeroes
 */

// @lc code=start
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.length() - b.length();
            }
        });
        // なるべく選びたい
        // dp[i+1] = F(dp[i])の形で表すことはできるか？
        // [0,0,1], m = 1, n = 1である時
        // dp[0] = 1
        // dp[1] = 1 // すでにm=1を使ったので1のまま
        // dp[2] = 2 // n = 1を支える
        // dp[i] = (0,1の個数がそれぞれm,nを超過するか判定) ? dp[i]: dp[i] + 1;
        // Greedy + DPの組み合わせでうまくいきそう！

        /**
         * ["10","0001","111001","1","0"]
            4
            3
            0 , 1, 10 , 0001, 111001
            dp[0] : 1
            dp[1] : 2
            dp[2] : 3 zero = 2, one = 2
            dp[3] : 
         */
        int zero = 0;
        int one = 0;
        int length = strs.length;
        int[] dp = new int[length];

        for (int i = 0; i < length; i++) {
            char[] arr = strs[i].toCharArray();
            int cur_zero = 0;
            int cur_one = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == '0') {
                    cur_zero++;
                } else {
                    cur_one++;
                }
            }
            if (zero + cur_zero <= m && one + cur_one <= n) {
                dp[i] = (i == 0) ? 1 : dp[i - 1] + 1;
                zero += cur_zero;
                one += cur_one;
            } else {
                // 選ばない
                dp[i] = (i == 0) ? 0 : dp[i - 1];
            }
        }
        return dp[length-1];
    }
}
// @lc code=end

