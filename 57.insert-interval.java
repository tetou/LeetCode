/*
 * @lc app=leetcode id=57 lang=java
 *
 * [57] Insert Interval
 */

// @lc code=start
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // intervalsにnewIntervalを投入する
        int N = intervals.length;
        int[][] itvl = new int[N+1][2];
        for (int i = 0;i < N;i++) {
            itvl[i] = intervals[i];
        }
        itvl[N] = newInterval;

        // start順にソートする
        Arrays.sort(itvl, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        List<int[]> list = new ArrayList<>();

        int cur_start = itvl[0][0];
        int cur_end = itvl[0][1];

        Stack<Integer> endStack = new Stack<Integer>();
        endStack.push(cur_end);

        for (int i = 1; i <= N; i++) {
            int start = itvl[i][0];
            int end = itvl[i][1];

            if (!endStack.isEmpty() && endStack.peek() >= start) {
                // マージ可能
                if (endStack.peek() < end) {
                    endStack.pop();
                    endStack.push(end);
                }
            } else {
                // マージ不可
                list.add(new int[]{cur_start, endStack.pop()});
                cur_start = start;
                endStack.push(end);
            }
        }
        if (!endStack.isEmpty()) {
            list.add(new int[]{cur_start, endStack.pop()});
        }

        int M = list.size();
        int[][] result = new int[M][2];
        for (int i = 0; i< M; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
// @lc code=end

