/*
 * @lc app=leetcode id=60 lang=java
 *
 * [60] Permutation Sequence
 */

// @lc code=start
class Solution {
    private TreeSet<String> result;
    private int n;
    public String getPermutation(int n, int k) {
        this.result = new TreeSet<String>();
        this.n = n;
        // 1-nが使われたかどうかを管理する
        boolean[] used = new boolean[n+1];
        Arrays.fill(used, false);
        // backtrackingを起動
        for (Integer i = 1; i <= n; i++) {
            help(i, used, "");
        }
        int index = 0;
        for (String tmp : result) {
            if (++index == k) return tmp;
        }
        // ここには来ないはず
        return null;
    }

    private void help(Integer i, boolean[] used, String str) {
        str += i.toString();

        if (str.length() == n) {
            result.add(str);
            return;
        }

        // 使用済フラグ
        used[i] = true;

        for (Integer j = 1; j <= n; j++) {
            if (i != j && !used[j]) {
                help(j, used, new String(str));
            }
        }

        // フラグ戻し
        used[i] = false;

    }
}
// @lc code=end

