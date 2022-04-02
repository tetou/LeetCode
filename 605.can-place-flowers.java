/*
 * @lc app=leetcode id=605 lang=java
 *
 * [605] Can Place Flowers
 */

// @lc code=start
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // 0が連続している箇所を全て確認して、植えられる最大数が出せる
        // 端っこについては特別な考慮が必要
        // [0,0,0,0,0] -> 3本
        // 端っこから始まる場合は0の個数/2
        // 端っこでない場合には0num/2 + 0num%2 - 1
        // [0,0,0,0,0,1,0,0,0,1,0,0,1,0]
        List<Integer> zeroCount = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1 && count > 0) {
                zeroCount.add(count);
                count = 0;
            } else if (flowerbed[i] == 0) {
                count++;
            }
        }
        if (count > 0) {
            zeroCount.add(count);
        }
        int result = 0;
        if (zeroCount.size() == 1 && zeroCount.get(0) == flowerbed.length) {
            // 全ての枠が埋まっていない状況なので余裕
            return n <= flowerbed.length /2 + flowerbed.length % 2;
        }
        for (int i = 0; i < zeroCount.size() ; i++) {
            if (flowerbed[0] == 0 && i == 0) {
                result += zeroCount.get(i) / 2;
            } else if (flowerbed[flowerbed.length-1] == 0 && i == zeroCount.size()-1) {
                result += zeroCount.get(i) / 2;
            } else {
                // 端っこではない
                result += zeroCount.get(i) / 2 + zeroCount.get(i) % 2 - 1;
            }
        }
        return n <= result;
    }
}
// @lc code=end

