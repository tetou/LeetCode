/*
 * @lc app=leetcode id=32 lang=java
 *
 * [32] Longest Valid Parentheses
 */

// @lc code=start
class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int result = 0;
        int sum = 0;
        // 総当たりで実装する
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n;j++) {
                // 検査対象の文字列
                String sub = s.substring(i,j+1);
                // Stackを使い、ちゃんとかっこが閉じられていることを確認する
                Stack<Character> stack = new Stack<Character>();
                boolean flg = true;
                for (int k = 0; k < sub.length(); k++) {
                    char tmp = sub.charAt(k);

                    if (tmp == '(') {
                        stack.push(tmp);
                    } else {
                        if (!stack.isEmpty()) {
                            stack.pop();
                        } else {
                            // 閉じかっこに対応する開きかっこがないので終了
                            flg = false;
                            break;
                        }
                    }
                }
                // 上記のチェックが全て通った
                if (flg && stack.isEmpty()) result = Math.max(result, sub.length());
            }
        }
        return result;
    }
}
// @lc code=end

