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
    public ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode current = head;
        //First pass to count the number of nodes
        while(current != null){
            count++;
            current = current.next;
        }
        //Second pass to find the middle node
        current = head;
        for(int i = 0; i < count / 2; i++){
            current = current.next;
        }
        return current;//This will be the middle node
    }
}