import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> list = new PriorityQueue<Integer>();
        for (int i = 0; i<lists.length; i++) {
            ListNode head = lists[i];
            while (head != null) {
                list.add(head.val);
                head = head.next;
            }
        }
        ListNode dummyHead = new ListNode(0);
        ListNode cursor = dummyHead;
        while (!list.isEmpty()) {
            cursor.next = new ListNode(list.poll());
            cursor = cursor.next;
        }
        return dummyHead.next;
    }
}
// @lc code=end

