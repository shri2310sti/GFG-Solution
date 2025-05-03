//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Node {
    Node next;
    int val;

    public Node(int data) {
        val = data;
        next = null;
    }
}

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t;
        t = Integer.parseInt(in.readLine());
        while (t-- > 0) {

            Node head, tail;
            String s[] = in.readLine().trim().split(" ");
            int num = Integer.parseInt(s[0]);
            head = new Node(num);
            tail = head;
            for (int i = 1; i < s.length; i++) {
                num = Integer.parseInt(s[i]);
                tail.next = new Node(num);
                tail = tail.next;
            }
            Solution ob = new Solution();
            Node temp = ob.primeList(head);
            while (temp != null) {
                out.print(temp.val + " ");
                temp = temp.next;
            }
            out.println();
            out.println("~");
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java
/*
class Node{
    Node next;
    int val;
    public Node(int data){
        val=data;
        next=null;
    }
}
*/

class Solution {
    Node primeList(Node head) {
        // Step 1: Generate all primes up to 2 * 10^4
        int MAX = 20000;
        boolean[] isPrime = new boolean[MAX + 1];
        for (int i = 2; i <= MAX; i++) isPrime[i] = true;
        for (int i = 2; i * i <= MAX; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Step 2: Traverse linked list and replace value with nearest prime
        Node curr = head;
        while (curr != null) {
            curr.val = findNearestPrime(curr.val, isPrime);
            curr = curr.next;
        }
        return head;
    }

    int findNearestPrime(int val, boolean[] isPrime) {
        int lower = val;
        int upper = val;

        // Go down to find the nearest smaller/equal prime
        while (lower >= 2 && !isPrime[lower]) {
            lower--;
        }

        // Go up to find the nearest greater/equal prime
        while (upper < isPrime.length && !isPrime[upper]) {
            upper++;
        }

        // Handle cases where lower may be out of range
        if (lower < 2) return upper;
        if (upper >= isPrime.length) return lower;

        // Return the closer one, or the smaller if equidistant
        if (val - lower <= upper - val) {
            return lower;
        } else {
            return upper;
        }
    }
}
