/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        // 区間をスタート地点によってsortする
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        List<int[]> list = new ArrayList<>();

        // 区間の終了をstackに保存しておく
        Stack<Integer> stack = new Stack<>();
        int cur_start = intervals[0][0];
        int cur_end = intervals[0][1];
        stack.push(cur_end);

        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (!stack.isEmpty() && stack.peek() >= start) {
                // マージ可能なので更新する
                if (end > stack.peek()) {
                    stack.pop();
                    stack.push(end);
                }
            } else {
                // マージできないので結果リストへ追加
                list.add(new int[]{cur_start, stack.pop()});
                cur_start = start;
                stack.push(end);
            }
        }
        // 最後の要素を考慮する
        if (!stack.isEmpty()) {
            list.add(new int[]{cur_start, stack.pop()});
        }

        int[][] result = new int[list.size()][2];
        for (int i = 0;i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
// @lc code=end

