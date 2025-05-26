class Solution {
    public Node sortedInsert(Node head, int data) {
        Node newNode = new Node(data);

        // Case 1: Empty list
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        Node current = head;

        // Case 2: New node to be inserted before head (new min)
        // or somewhere in the middle/end
        while (true) {
            // Normal position between two nodes
            if (current.data <= data && data <= current.next.data) {
                break;
            }

            // Case where we need to insert at the end or before head
            if (current.data > current.next.data) {
                // We're at the max node (pointing to min)
                if (data >= current.data || data <= current.next.data) {
                    break;
                }
            }

            current = current.next;

            // Came full circle without finding a spot
            if (current == head) break;
        }

        // Insert new node
        newNode.next = current.next;
        current.next = newNode;

        // Return updated head (no need to change head unless new node is the new min)
        return head.data < data ? head : newNode;
    }
}
