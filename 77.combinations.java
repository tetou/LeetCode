/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 */

// @lc code=start
class Solution {
    private int n, k;
    private Set<List<Integer>> result;
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k; 
        this.result = new HashSet<List<Integer>>();

        help(new int[n+1], new ArrayList<>());

        List<List<Integer>> result2 = new ArrayList<List<Integer>>();
        for (List<Integer> element: result) {
            result2.add(element);
        }
        return result2;
    }


    /** 
     * index : どこから探索を開始するか？
     * used : すでに使われた数を管理する
     * list : 生成された組み合わせを引き継ぎ（一意性を保つためにsortしておく）
    */
    private void help(int[] used, List<Integer> list) {
        if (list.size() == k) {
            Collections.sort(list);
            result.add(list);
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (used[i] == 0) {
                int[] tmp = Arrays.copyOf(used, n+1);
                tmp[i] = 1;
                ArrayList<Integer> tmp2 = new ArrayList<Integer>(list);
                tmp2.add(i);
                help(tmp, tmp2);
            }
        }
    }
}
// @lc code=end

