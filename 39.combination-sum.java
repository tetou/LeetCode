/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 */

// @lc code=start
class Solution {
    private int[] candidates;
    private int target;
    private List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        this.result = new ArrayList<List<Integer>>();
        for (int i = 0; i < candidates.length; i++) {
            help(i, new ArrayList<>(), 0);
        }
        return result;
    }

    /**
     *  
     * @param i
     * @param combi 構築済の組み合わせ
     */
    private void help(int i, List<Integer> combi, int sum) {
        int nextSum = sum + candidates[i];
        combi.add(candidates[i]);
        if (nextSum > target) {
            return;
        } else if (nextSum == target) {
            result.add(combi);
            return;
        } else {
            // まだ未達の場合は次の組み合わせを調べる
            for (int j = i; j < candidates.length; j++) {
                help(j, new ArrayList<>(combi), nextSum);
            }
        }
    }
}
// @lc code=end

