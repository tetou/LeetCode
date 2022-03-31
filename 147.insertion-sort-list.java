/*
 * @lc app=leetcode id=147 lang=java
 *
 * [147] Insertion Sort List
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
    public ListNode insertionSortList(ListNode head) {
        // まずは配列に突っ込んでから挿入ソートする
        List<Integer> list = new ArrayList<Integer>();
        while (head != null) { 
            list.add(head.val);
            head = head.next;
        }

        int N = list.size();
        int[] arr = new int[N];
        int index = 0;
        for (Integer i : list) {
            arr[index++] = i;
        }

        // 挿入ソート
        for (int i= 1;i < N;i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j-1] > arr[j]) {
                    int backup = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = backup;
                }
            }
        }

        // レスポンスを構築
        ListNode dummyHead = new ListNode(-5001);
        ListNode cursor = dummyHead;
        for (int i = 0; i < N; i++) {
            cursor.next = new ListNode(arr[i]);
            cursor = cursor.next;
        }

        return dummyHead.next;
    }
}
// @lc code=end

