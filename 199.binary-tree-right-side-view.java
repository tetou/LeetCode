/*
 * @lc app=leetcode id=199 lang=java
 *
 * [199] Binary Tree Right Side View
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // 深さ -> nodeを右から順番に登録するマップ
    private Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public List<Integer> rightSideView(TreeNode root) {
        // 各深さで一番右にくるnodeを特定すれば良い
        help(root, 0);

        List<Integer> result = new ArrayList<Integer>();

        for (Integer dep : map.keySet()) {
            result.add(map.get(dep));
        }

        return result;
    }

    private void help(TreeNode node, int depth) {
        if (node != null) {

            if (map.containsKey(depth)) {
                // すでに先客がいるので何もしない
            } else {
                map.put(depth, node.val);
            }
            help(node.right, depth+1);
            help(node.left, depth+1);
        }
    }
}
// @lc code=end

