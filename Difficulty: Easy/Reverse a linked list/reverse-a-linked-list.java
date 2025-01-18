//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class GFG {
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;

            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }

            Solution ob = new Solution();
            head = ob.reverseList(head);
            printList(head);
            t--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// function Template for Java

/* linked list node class:

class Node {
    int data;
    Node next;
    Node(int value) {
        this.value = value;
    }
}

*/



class Solution {
    Node reverseList(Node head) {
        Node prev = null;   // Previous node
        Node curr = head;   // Current node

        while (curr != null) {
            Node next = curr.next; // Store the next node
            curr.next = prev;      // Reverse the link
            prev = curr;           // Move prev to the current node
            curr = next;           // Move curr to the next node
        }

        return prev; // New head of the reversed list
    }
}
