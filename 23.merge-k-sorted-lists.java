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
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i<lists.length; i++) {
            ListNode head = lists[i];
            while (head != null) {
                list.add(head.val);
                head = head.next;
            }
        }
        Collections.sort(list);
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

