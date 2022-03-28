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
    // 深さ -> nodeを左から順番に登録するリスト
    private Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

    public List<Integer> rightSideView(TreeNode root) {
        // 各深さで一番右にくるnodeを特定すれば良い
        help(root, 0);

        List<Integer> result = new ArrayList<Integer>();

        for (Integer dep : map.keySet()) {
            List<Integer> l = map.get(dep);
            result.add(l.get(l.size()-1));
        }

        return result;
    }

    private void help(TreeNode node, int depth) {
        if (node != null) {
            List<Integer> list = map.getOrDefault(depth, new ArrayList<>());
            list.add(node.val);
            map.put(depth, list);
            help(node.left, depth+1);
            help(node.right, depth+1);
        }
    }
}
// @lc code=end

