/*
 * @lc app=leetcode id=826 lang=java
 *
 * [826] Most Profit Assigning Work
 */

// @lc code=start
class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        // workerごとに、対応可能かつprofitがなるべく大きくなるような組み合わせでアサインする
        int result = 0;
        // profit -> difficultyのマップを作っておき、profitの大きい順に並べて調べる
        Map<Integer, Integer> profitToDiff = new HashMap<>();

        // O(n)
        for (int i = 0; i < profit.length; i++) {
            int tmp = profitToDiff.getOrDefault(profit[i], Integer.MAX_VALUE);
            // そのprofitを得られるための最小難易度を保存する
            tmp = Math.min(tmp, difficulty[i]);
            profitToDiff.put(profit[i], tmp);
        }
        // profitのリストを作成する
        List<Integer> profList = new ArrayList<>();
        // O(n)
        for (int i = 0; i < profit.length; i++) {
            profList.add(profit[i]);
        }
        Collections.sort(profList, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    
        // O(m*n)
        for (int w : worker) {
            for (Integer prof : profList) {
                int diff = profitToDiff.get(prof);
                if (diff <= w) {
                    result += prof;
                    break;
                }
            }
        }
        return result;
        
    }
}
// @lc code=end

