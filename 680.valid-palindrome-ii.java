/*
 * @lc app=leetcode id=680 lang=java
 *
 * [680] Valid Palindrome II
 */

// @lc code=start
class Solution {
    public boolean validPalindrome(String s) {
        if (s.length() == 1) return true;
        // キューに詰めて左右から取り除いていく
        // abcdgdpcba
        // a -> b -> c -> d != p
        // Palindromeなので、それぞれの文字の数は倍数または、１文字だけ奇数になる
        // 奇数の文字を探して、それは取り除く対象である
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        ArrayDeque<Character> queue = new ArrayDeque<Character>();

        for (int i = 0; i <s.length(); i++) {
            char sc = s.charAt(i);
            queue.add(sc);
            Integer cnt = map.getOrDefault(sc,0);
            cnt++;
            map.put(sc, cnt);
        }
        Set<Character> oddChar = new HashSet<Character>();
        for (Character c : map.keySet()) {
            if (map.get(c) % 2 == 1) {
                oddChar.add(c);
            }
        }

        while (!queue.isEmpty()) {
            if (queue.size() > 1) {
                char first = queue.peek();
                char last = queue.peekLast();
                if (first != last) {
                    if (oddChar.contains(first)) {
                        queue.poll();
                    } else if (oddChar.contains(last)) {
                        queue.pollLast();
                    } else {
                        return false;
                    }
                } else {
                    queue.poll();
                    queue.pollLast();
                }
            } else {
                queue.poll();
            }
        }
        return true;
    }
}
// @lc code=end

