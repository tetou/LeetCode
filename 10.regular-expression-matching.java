/*
 * @lc app=leetcode id=10 lang=java
 *
 * [10] Regular Expression Matching
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        // a*でひとつとみなせるようにする
        // aの0回以上の繰り返し -> aがない場合にはスキップ、あればあった分だけpop
        // .* -> 任意の文字を任意の回数だけpopできる
        ArrayDeque<String[]> queue = new ArrayDeque<String[]>();
        for (int i = 0; i < p.length(); i++) {
            String ps = p.substring(i,i+1);
            String[] tmp = new String[2];
            if (i < p.length()-1) {
                String ps_next = p.substring(i+1,i+2);
                if (ps_next.equals("*")) {
                    tmp[0] = ps;
                    tmp[1] = ps_next;
                    i++; // ひとつ進める
                } else {
                    tmp[0] = ps;
                    tmp[1] = "1";
                }
            } else {
                tmp[0] = ps;
                tmp[1] = "1";
            }
            queue.add(tmp);
        }

        // String sもqueueに詰めておく
        ArrayDeque<String> source = new ArrayDeque<String>();
        for (int i = 0; i < s.length(); i++) {
            source.add(s.substring(i,i+1));
        }

        while (!queue.isEmpty()) {
            if (source.isEmpty()) {
                // まだチェック終わっていない段階でチェック対象文字列が空になったらfalse
                return false;
            }

            String[] criteria = queue.poll();
            String c = criteria[0];
            String n = criteria[1];
            if (c.equals(".")) {
                if (n.equals("1")) {
                    // 任意の文字を１つ取り除く
                    source.poll();
                } else if (n.equals("*")) {
                    while (!source.isEmpty()) {
                        source.poll(); // 任意の文字の任意の組み合わせなので全部取り除く
                    }
                }
            } else {
                if (n.equals("*")) {
                    // 0回以上、特定の文字を削除
                    while (!source.isEmpty() && source.peek().equals(c)) {
                        source.poll();
                    }
                } else {
                    if (!source.isEmpty() && source.peek().equals(c)) {
                        source.poll();
                    } else {
                        return false;
                    }
                }
            }
        }

        // チェックに基づいて取り除いた結果、文字列が全て消えればOK
        return source.size() == 0;
    }
}
// @lc code=end

