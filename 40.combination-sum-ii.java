/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 */

// @lc code=start
class Solution {
    private int[] candidates;
    private int target;
    private Set<List<Integer>> result;
    

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        this.result = new HashSet<List<Integer>>();

        for (int i = 0; i < candidates.length; i++) {
            help(i, new ArrayList<>(), 0);
        }

        List<List<Integer>> result1 = new ArrayList<>();
        for (List<Integer> l : result) {
            result1.add(l);
        }
        return result1;
    }

    private void help(int i, List<Integer> list, int sum) {
        int nextSum = candidates[i] + sum;
        list.add(candidates[i]);
        if (nextSum == target) {
            Collections.sort(list);
            result.add(list);
            return;
        } else if (nextSum > target) {
            // 超過してしまったのでスキップ
            return;
        } else {
            // 余剰があるので、続きを処理する。重複を許さないので１つあとのインデックスから処理を始める
            for (int j = i+1; j < candidates.length; j++) {
                help(j, new ArrayList<>(list), nextSum);
            }
        }
    }
}
// @lc code=end

