// User function Template for Java

/* Structure of Doubly Linked List
class Node
{
    int data;
    Node next;
    Node prev;
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}*/
class Solution {
    static Node deleteAllOccurOfX(Node head, int x) {
        // Write your code here
        if(head == null || (head.next == null && head.data == x)) return null;
        Node temp = head;
        while(temp != null){
            if(temp.prev == null && temp.data == x){
                head = head.next;
                if(head != null) head.prev = null;
            }
            else if(temp.next == null && temp.data == x){
                temp.prev.next = null;
                temp.next = null;
            } else{
                if(temp.data == x){
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
            }
            temp = temp.next;
        }
        return head;
        
    }
}