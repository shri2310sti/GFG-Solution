/*
class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}
*/

class Solution {
    // Function to find the length of a loop in the linked list.
    public int countNodesinLoop(Node head) {
        // code here.
        HashMap<Node, Integer> mpp = new HashMap<>();
        Node temp = head;
        int t = 1;
        while(temp != null){
            if(mpp.containsKey(temp)){
                int loopLen = t - mpp.get(temp);
                return loopLen;
            }
            mpp.put(temp, t);
            temp = temp.next;
            t++;
        }
        return 0;
    }
}