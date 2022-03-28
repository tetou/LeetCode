/*
 * @lc app=leetcode id=107 lang=java
 *
 * [107] Binary Tree Level Order Traversal II
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
    private Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // left -> rightの順にDFSしてdepthごとのリストを作成する
        // depth順にCollections.sortしてあげる
        help(root, 0);

        List<Integer> depthList = new ArrayList<Integer>();
        for (Integer dep : map.keySet()) {
            depthList.add(dep);
        }
        Collections.sort(depthList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for (Integer key : depthList) {
            result.add(map.get(key));
        }

        return result;
    }

    private void help(TreeNode node, int depth) {
        if (node != null) {
            List<Integer> list = map.getOrDefault(depth, new ArrayList<>());
            list.add(node.val);
            map.put(depth, list);
            help(node.left, depth + 1);
            help(node.right, depth + 1);
        }
    }
}
// @lc code=end

