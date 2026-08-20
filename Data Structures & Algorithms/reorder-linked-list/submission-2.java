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
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode Next = null;
        while(curr!=null){
            Next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = Next;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        slow = reverseList(slow);

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode temp = dummy;
        while(head!=null){
            temp.next = head;
            head = head.next;
            temp = temp.next;

            temp.next = slow;
            slow = slow.next;
            temp = temp.next;
        }
    }
}
