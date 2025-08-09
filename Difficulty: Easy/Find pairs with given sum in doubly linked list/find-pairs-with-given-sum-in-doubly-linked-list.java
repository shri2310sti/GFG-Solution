/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next,prev;

    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target,Node head) {
        // code here
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        
        Node left = head, right = findtail(head);
        
        while(left.data < right.data){
            if(left.data + right.data > target){
                right = right.prev;
            }else if(left.data + right.data < target){
                left = left.next;
            }else{
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(left.data);
                pair.add(right.data);
                arr.add(pair);
                left = left.next;
                right = right.prev;
            }
        }
        return arr;
    }
    private static Node findtail(Node head){
        Node tail = head;
        while(tail.next != null){
            tail = tail.next;
        }
        return tail;
    }
}
