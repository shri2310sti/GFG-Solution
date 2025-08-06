/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    public Node addOne(Node head) {
        // code here.
        head = reverse(head);
        Node temp = head; int carry = 1;
        while(temp != null){
            temp.data = temp.data + carry;
            if(temp.data < 10){
                carry = 0;
                break;
            } else {
                temp.data = 0;
                carry = 1;
            }
            temp = temp.next;
        }
        if(carry == 1){
            Node newNode = new Node(1);
            head = reverse(head);
            newNode.next = head;
            return newNode;
        } 
        head = reverse(head);
        return head;
    }
    private static Node reverse(Node head){
        Node temp = head;
        Node prev = null;
        while(temp != null){
            Node t = temp.next;
            temp.next = prev;
            prev = temp;
            temp = t;
        }
        return prev;
    }
}