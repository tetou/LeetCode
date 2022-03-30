/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start
class Solution {
    /**
     * [-2,0,1,1,2]
     * i = -2, left = 0, right = 2
     * i = -2, 0の時は増やすだけだと増えるが、減らせば0になる可能性が再び生じる
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) return result;
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            int left = i+1;
            int right = n-1;
            while (left < right) {
                int total = nums[i] + nums[left] + nums[right];
                if (total < 0) {
                    left++;
                } else if (total > 0) {
                    right--;
                } else {
                    // 0になったので結果に追加
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    set.add(list);
                    // 0の場合にはleft,rightどっちも動かすことで0になる可能性が再びある
                    left++;
                    right--;
                }
            }
        }
        for (List<Integer> l : set) {
            result.add(l);
        }
        return result;
    }
}
// @lc code=end

