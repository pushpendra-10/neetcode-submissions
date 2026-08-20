/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // create deepcopy with same next Nodes but null random pointers
        Node dummy = new Node(-1);
        Node temp = dummy;
        Node temp1 = head;
        while(temp1 != null){
            temp.next = new Node(temp1.val);
            temp = temp.next;
            temp1 = temp1.next;
        }

        // join two list alternatively
        Node head2 = dummy.next;
        temp = dummy;
        temp1 = head;
        Node temp2 = head2;
        while(temp1!=null && temp2!=null){
            temp.next = temp1;
            temp1 = temp1.next;
            temp = temp.next;

            temp.next = temp2;
            temp2 = temp2.next;
            temp = temp.next;
        }

        // assign random pointer of copied list;
        temp1 = head;
        temp2 = head2;
        while(temp1 != null){
            if(temp1.random != null) temp2.random = temp1.random.next;
            temp1 = temp2.next;
            if(temp1!=null)temp2 = temp1.next;
        }

        // separate the lists
        temp1 = head;
        temp2 = head2;
        while(temp1!=null && temp2!=null){
            temp1.next = temp2.next;
            temp1 = temp1.next;

            if(temp1 == null) break;
            temp2.next = temp1.next;
            temp2 = temp2.next;
        }
        return head2;
    }
}
