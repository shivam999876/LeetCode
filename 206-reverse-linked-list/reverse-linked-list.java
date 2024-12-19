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
    public ListNode reverseList(ListNode head) {
         // Base Case
        if (head == null || head.next == null) {
            return head;
        }
        // Sub Problem
        ListNode nxt = head.next;
        ListNode revHead = reverseList(head.next);
        head.next = null;
        nxt.next = head;
        return revHead;
    }
}