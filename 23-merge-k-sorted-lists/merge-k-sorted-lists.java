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
        if(lists.length==0||(lists.length==1&&lists[0]==null))
        return null;
        ListNode head=null,curr=head;
        PriorityQueue<ListNode> p = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(int i=0;i<lists.length;i++){
             curr=lists[i];
            while(curr!=null){
                  p.add(curr);
                if(curr.next==null)
                break;
                curr=curr.next;
             }
             if(i==lists.length-1)
             break;
             if(curr==null)
             continue;
             curr.next=lists[i+1];

        }
        ListNode n=null,temp=null;
            while(p.size()>0){
                n=p.poll();
                if(head==null)
                head=n;
                if(temp==null){
                    temp=n;
                }
                else {
                    temp.next=n;
                    temp=temp.next;
                    n.next=null;
                }
        }
      return head;
    }
}