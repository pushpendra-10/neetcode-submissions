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
        if(k==1) return head;
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode temp = head;
        int len = 0;
        while(temp!=null){
            temp = temp.next;
            len++;
        }
        int n = len/k;

        ListNode prev = dummy;
        ListNode curr = head;
        ListNode Next = head.next;
        for(int i=0; i<n; i++){
            for(int j=1; j<k; j++){
                curr.next = Next.next;
                Next.next = prev.next;
                prev.next = Next;
                Next = curr.next;
            }
            prev = curr;
            curr = curr.next;
            if(curr!=null)Next = curr.next;
        }
        return dummy.next;
    }
}