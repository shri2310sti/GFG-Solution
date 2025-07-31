/* class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}*/
class Solution {
    static Node segregate(Node head) {
        // code here
        if(head == null) return head;
        int[] arr = new int[3];
        Node temp = head;
        while(temp != null){
            arr[temp.data]++;
            temp = temp.next;
        }
        temp = head;
        int i = 0;
        while(temp != null){
            if(arr[i] == 0){
                i++;
            } else {
                temp.data = i;
                arr[i]--;
                temp = temp.next;
            }
        }
        return head;
    }
}