/*
 * @lc app=leetcode id=680 lang=java
 *
 * [680] Valid Palindrome II
 */

// @lc code=start
class Solution {
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        while (i < j) {
            // もしミスマッチが発生したら、ひとつずつずらしたバージョンで試す
            if (s.charAt(i) != s.charAt(j)) {
                return checkPal(s, i+1,j) || checkPal(s,i,j-1);
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean checkPal(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}
// @lc code=end

