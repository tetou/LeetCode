/*
 * @lc app=leetcode id=86 lang=java
 *
 * [86] Partition List
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
    public ListNode partition(ListNode head, int x) {
        /**
         * x より小さいノードと、x以上のノードを別々のキューに振り分け、ListNodeを作成する
         */
        ArrayDeque<Integer> lessQueue = new ArrayDeque<Integer>();
        ArrayDeque<Integer> greatQueue = new ArrayDeque<Integer>();

        ListNode dummyHead1 = head;

        while (head != null) { 
            if (head.val < x) {
                lessQueue.add(head.val);
            } else {
                greatQueue.add(head.val);
            }
            head = head.next;
        }

        if (lessQueue.isEmpty() || greatQueue.isEmpty()) {
            // そのままheadを返す
            return dummyHead1;
        } else {
            ListNode dummyHead = new ListNode(0);
            ListNode cursor = dummyHead;

            while (!lessQueue.isEmpty()) {
                cursor.next = new ListNode(lessQueue.poll());
                cursor = cursor.next;
            }
            while (!greatQueue.isEmpty()) {
                cursor.next = new ListNode(greatQueue.poll());
                cursor = cursor.next;
            }

            return dummyHead.next;
        }
    }
}
// @lc code=end

