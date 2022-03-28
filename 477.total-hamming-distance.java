import java.util.ArrayDeque;

/*
 * @lc app=leetcode id=477 lang=java
 *
 * [477] Total Hamming Distance
 */

// @lc code=start
class Solution {
    public int totalHammingDistance(int[] nums) {
        int result = 0;

        // 32bitの配列を用意する
        int[] cnt = new int[32];

        int length = nums.length;

        for (int i = 0; i < length; i++) {
            int n = nums[i];
            int index = 0;
            while (n > 0) {
                if ((n & 1) == 1) {
                    cnt[index]++;
                }
                index++;
                n>>=1;
            }
        }

        // [1,2,3]
        // [1, 10, 11]
        // bit [22]
        for (int i = 0; i < 32; i++) {
            int k = cnt[i];
            result += k * (length - k);
        }

        return result;
    }

}
// @lc code=end

