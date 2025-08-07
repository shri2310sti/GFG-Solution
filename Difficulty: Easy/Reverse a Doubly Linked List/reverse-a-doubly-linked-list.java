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
    public DLLNode reverseDLL(DLLNode head) {
        if(head == null || head.next == null) return head;

        DLLNode curr = head;
        DLLNode prev = null;
        
        while(curr != null){
            DLLNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr.prev = next;
            curr = curr.prev;
        }
        return prev;
    }
}