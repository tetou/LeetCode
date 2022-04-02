/*
 * @lc app=leetcode id=187 lang=java
 *
 * [187] Repeated DNA Sequences
 */

// @lc code=start
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<String>();
        Map<String, Integer> counter = new HashMap<String, Integer>();
        if (s.length() < 10) return result;

        for (int i = 0; i < s.length() - 9;i++) {
            String sub = s.substring(i,i+10);
            Integer count = counter.getOrDefault(sub,0);
            count++;
            counter.put(sub,count);
        }

        for (String str : counter.keySet()) {
            if (counter.get(str) > 1) result.add(str);
        }

        return result;
    }
}
// @lc code=end

