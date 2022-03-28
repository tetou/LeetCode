/*
 * @lc app=leetcode id=860 lang=java
 *
 * [860] Lemonade Change
 */

// @lc code=start
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five_changes = 0;
        int ten_notes = 0;
        for (int i = 0; i < bills.length; i ++) {
            int b = bills[i];
            if (b == 5) {
                five_changes++;
            } else if (b == 10) {
                if (five_changes == 0) {
                    return false;
                } else {
                    five_changes--;
                    ten_notes++;
                }
            } else if (b == 20) {
                // $15のおつりは、10 + 5 or 5 + 5 + 5の2パタンだけ
                if (ten_notes >= 1 && five_changes >= 1) {
                    // $20はお釣りとして使わないので保存はしない
                    ten_notes--;
                    five_changes--;
                } else if (five_changes >= 3) {
                    five_changes-=3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end

