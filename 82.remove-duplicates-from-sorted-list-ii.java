import java.util.ArrayDeque;

/*
 * @lc app=leetcode id=82 lang=java
 *
 * [82] Remove Duplicates from Sorted List II
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
    public ListNode deleteDuplicates(ListNode head) {
        // Space complexity : N
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();

        int multiCount = 1;
        while (head != null) {
            if (queue.isEmpty()) {
                // 何も入っていない場合は入れてOK
                queue.add(head.val);
            } else if (queue.peekLast() == head.val) { 
                // 以前入れたものと同じものが来たらカウントしておく
                queue.add(head.val);
                multiCount++;
            } else {
                // カウントされたものが存在すればその分、削除する
                if (multiCount > 1) {
                    for (int i = 0; i < multiCount; i++) {
                        queue.pollLast();
                    }
                    multiCount = 1;
                }
                queue.add(head.val);
            }
            head = head.next;
        }

        // 最後の要素が重複した場合の処理
        if (multiCount > 1) {
            for (int i = 0; i < multiCount; i++) {
                queue.pollLast();
            }
        }

        ListNode dummyHead = new ListNode(0);
        ListNode cursor = dummyHead;
        while (!queue.isEmpty()) {
            cursor.next = new ListNode(queue.poll());
            cursor = cursor.next;
        }
        return dummyHead.next;
    }
}
// @lc code=end

