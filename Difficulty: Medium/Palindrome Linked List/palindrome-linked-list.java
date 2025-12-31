

/* Structure of class Node is
class Node
{
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}*/
class Solution {
    // Function to check whether the list is palindrome.
    boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true; // A list with 0 or 1 node is always a palindrome.
        }
        
        // Step 1: Find the middle of the linked list
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Step 2: Reverse the second half of the linked list
        Node secondHalfHead = reverseList(slow);
        Node reverseHead = secondHalfHead; // Store the head of the reversed second half
        
        // Step 3: Compare the first half and the reversed second half
        Node firstHalfHead = head;
        boolean isPalindrome = true;
        while (secondHalfHead != null) {
            if (firstHalfHead.data != secondHalfHead.data) {
                isPalindrome = false;
                break;
            }
            firstHalfHead = firstHalfHead.next;
            secondHalfHead = secondHalfHead.next;
        }
        
        // Step 4: Restore the original list (optional)
        reverseList(reverseHead); // Reverse the second half back to its original order
        
        // Step 5: Return the result
        return isPalindrome;
    }
    
    // Helper function to reverse a linked list
    private Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

