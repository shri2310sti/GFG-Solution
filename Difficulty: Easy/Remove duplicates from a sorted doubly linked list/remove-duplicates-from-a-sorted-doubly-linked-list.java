// User function Template for Java

class Solution {
    Node removeDuplicates(Node head) {
        // Code Here.
        if(head == null || head.next == null) return head;
        Node temp = head;
        while(temp != null && temp.next != null){
            if(temp.data == temp.next.data){
                Node dup = temp.next;
                temp.next = dup.next;
                if(dup.next != null){
                    dup.next.prev = temp;
                }
            } else temp = temp.next;
        }
        return head;
    }
}