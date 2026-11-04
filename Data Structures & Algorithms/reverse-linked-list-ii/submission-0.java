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
    public void reverseList(ListNode curr){
        ListNode prev = null;
        ListNode Next = null;

        while(curr != null){
            Next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = Next;
        }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-501);
        dummy.next = head;

        ListNode predStart = dummy; // predecessor of start
        ListNode start = null; 

        for(int i=1; i<left; i++){
            predStart = predStart.next;
        }
        start = predStart.next;

        ListNode end = start;
        for(int i=left; i<right; i++){
            end = end.next;
        }
        ListNode succEnd = end.next;

        predStart.next = null;
        end.next = null;

        reverseList(start);

        predStart.next = end;
        start.next = succEnd;

        return dummy.next;
    }
}