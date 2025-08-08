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
        while(head != null && head.data == x){
            head = head.next;
        }
        
        Node temp = head;
        while(temp != null && temp.next != null){
            if(temp.next.data == x){
                temp.next = temp.next.next;
            }
            else temp = temp.next;
        }
        return head;
    }
}