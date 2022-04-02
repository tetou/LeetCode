/*
 * @lc app=leetcode id=137 lang=java
 *
 * [137] Single Number II
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        int bef = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (bef != nums[i] && count == 1) {
                return bef;
            } else if (bef != nums[i] && count == 3) {
                // ただの変わり目なので何もせずカウントリセット
                count = 1;
                bef = nums[i];
            } else if (bef == nums[i]) {
                // 同じものが存在したのでカウント
                count++;
                // befは同じなので更新不要
            }
        }
        // ここまできたら最後の数がシングルだったことがわかるので、その値を返す
        return nums[nums.length -1];
    }
}
// @lc code=end

