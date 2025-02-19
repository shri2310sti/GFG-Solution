//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class Main {
    /* Function to print nodes in a given linked list */
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    // Driver program to test the above functions
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        while (t-- > 0) {
            int n = Integer.parseInt(scanner.nextLine());
            List<Node> lists = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String line = scanner.nextLine();
                String[] values = line.split(" ");
                Node head = null, temp = null;

                for (String value : values) {
                    Node newNode = new Node(Integer.parseInt(value));
                    if (head == null) {
                        head = newNode;
                        temp = head;
                    } else {
                        temp.next = newNode;
                        temp = temp.next;
                    }
                }

                lists.add(head);
            }

            Solution sol = new Solution();
            Node head = sol.mergeKLists(lists);

            printList(head);
            System.out.println("~");
        }
        scanner.close();
    }
}

// } Driver Code Ends


// User function Template for Java
/*class Node
{
    int data;
    Node next;

    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/



class Solution {
    // Function to merge K sorted linked lists using Divide and Conquer
    Node mergeKLists(List<Node> arr) {
        if (arr == null || arr.size() == 0) return null;

        return mergeLists(arr, 0, arr.size() - 1);
    }

    // Function to merge lists using divide and conquer
    private Node mergeLists(List<Node> lists, int left, int right) {
        if (left == right) return lists.get(left);
        if (left + 1 == right) return mergeTwoLists(lists.get(left), lists.get(right));

        int mid = left + (right - left) / 2;
        Node leftMerged = mergeLists(lists, left, mid);
        Node rightMerged = mergeLists(lists, mid + 1, right);
        
        return mergeTwoLists(leftMerged, rightMerged);
    }

    // Function to merge two sorted linked lists
    private Node mergeTwoLists(Node l1, Node l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        Node dummy = new Node(-1);
        Node tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        if (l1 != null) tail.next = l1;
        if (l2 != null) tail.next = l2;

        return dummy.next;
    }
}
