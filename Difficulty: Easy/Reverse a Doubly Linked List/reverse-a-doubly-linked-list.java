/*
class DLLNode {
    int data;
    DLLNode next;
    DLLNode prev;

    DLLNode(int val) {
        data = val;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    public Node reverse(Node head) {
        while(head!=null){
            Node pre=head.next;
            head.next=head.prev;
            head.prev=pre;
            if(pre==null)return head;
            head=pre;
        }
        return head;
    }
}