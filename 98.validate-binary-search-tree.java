/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
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
    // [5,1,4,null,null,3,6]
    // leftはrootより小さい、rightはrootより大きい
    // root.left = 1 -> 5より小さいOK
    // root.right = 4 -> 5より小さい NG
    // nodeごとにlower_bound, upper_boundの制約をhelperに教えてあげてバリデーションに使う
    private int irregalCount = 0;
    private Set<Integer> set = new HashSet<Integer>();

    public boolean isValidBST(TreeNode root) {
        // 最初は制限なしの状態からスタート
        help(root, Integer.MIN_VALUE, Integer.MAX_VALUE);        

        return irregalCount == 0;
    }

    private void help(TreeNode node, int lower, int high) {
        if (node != null) {
            if (node.val < lower || node.val > high || set.contains(node.val)) irregalCount++;
            set.add(node.val);
            help(node.left, lower, Math.min(high, node.val)); // 左側のノードは今のノードより値が小さくないとだめ
            help(node.right, Math.max(lower, node.val), high); // 右側のノードは今のノードより値が大きくないとだめ
        }
    }
}
// @lc code=end

