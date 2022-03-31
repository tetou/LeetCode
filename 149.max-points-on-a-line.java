import java.util.HashMap;

/*
 * @lc app=leetcode id=149 lang=java
 *
 * [149] Max Points on a Line
 */

// @lc code=start
class Solution {
    public int maxPoints(int[][] points) {

        // X座標 -> 点の集合
        Map<Integer, Set<Pair<Integer,Integer>>> xMap = new HashMap<>();
        // Y座標 -> 点の集合
        Map<Integer, Set<Pair<Integer, Integer>>> yMap = new HashMap<>();
        // 傾き -> 点の集合
        Map<Double, Set<Pair<Integer, Integer>>> dMap = new HashMap<>();

        // 傾きの集合を考える
        // 点数は少ないので、全探索でも可能と思われる
        // X軸、Y軸と平行な点も考慮する
        int N = points.length;

        if (N == 1) return 1;

        // 以下2点以上存在することを仮定する
        for (int i = 0; i < N-1; i++) {
            // 軸に平行なパタンについてはややこしいので外す。斜めだけ
            for (int j = i+1; j<N;j++) {
                int[] p1 = points[i];
                int[] p2 = points[j];
                Integer p1_x = p1[0];
                Integer p1_y = p1[1];
                Integer p2_x = p2[0];
                Integer p2_y = p2[1];
                if (p1_x == p2_x) {
                    Set<Pair<Integer,Integer>> xSet = xMap.getOrDefault(p1_x, new HashSet<>());
                    xSet.add(new Pair<Integer,Integer>(p1_x,p1_y));
                    xSet.add(new Pair<Integer,Integer>(p2_x,p2_y));
                    xMap.put(p1_x, xSet);
                } else if (p1_y == p2_y) {
                    Set<Pair<Integer,Integer>> ySet = yMap.getOrDefault(p1_y, new HashSet<>());
                    ySet.add(new Pair<Integer,Integer>(p1_x,p1_y));
                    ySet.add(new Pair<Integer,Integer>(p2_x,p2_y));
                    yMap.put(p1_y, ySet);
                } else {
                    Double slope = (double)(p1_y - p2_y) / (p1_x - p2_x);
                    Set<Pair<Integer,Integer>> dSet = dMap.getOrDefault(slope, new HashSet<>());
                    dSet.add(new Pair<Integer,Integer>(p1_x,p1_y));
                    dSet.add(new Pair<Integer,Integer>(p2_x,p2_y));
                    dMap.put(slope, dSet);
                }
            }
        }

        int result = 0;
        for (Integer key : xMap.keySet()) {
            result = Math.max(result, xMap.get(key).size());
        }
        for (Integer key : yMap.keySet()) {
            result = Math.max(result, yMap.get(key).size());
        }
        for (Double key : dMap.keySet()) {
            result = Math.max(result, dMap.get(key).size());
        }
        return result;
    }
}
// @lc code=end

