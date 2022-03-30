/*
 * @lc app=leetcode id=25 lang=java
 *
 * [25] Reverse Nodes in k-Group
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 前から順番に読み込んでいって、k個ずつStackに突っ込んで
        // それをpopして新しい順番に並べ替える
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        // 並び替えた後の番号をリスト化する
        List<Integer> list = new ArrayList<>();

        int index = 0;
        while (head != null) { 
            stack.add(head.val);
            index++;
            if (index % k == 0) {
                while (!stack.isEmpty()) {
                    list.add(stack.pollLast());
                }
            }
            head = head.next;
        }
        // Queueに残ったものは順番を入れ替えないで取り出す
        while (!stack.isEmpty()) {
            list.add(stack.poll());
        }

        ListNode dummyHead = new ListNode(0);
        ListNode cursor = dummyHead;
        for (Integer i : list) {
            cursor.next = new ListNode(i);
            cursor = cursor.next;
        }
        return dummyHead.next;
    }
}
// @lc code=end

