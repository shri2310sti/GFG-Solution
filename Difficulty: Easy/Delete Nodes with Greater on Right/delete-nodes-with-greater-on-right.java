class Solution {
    private int dfs(Node head) {
        if(head == null) {
            return -1;
        }
        int nextValue = dfs(head.next);
        
        if(head.data < nextValue) {
            head.data = head.next.data;
            head.next = head.next.next;
        }
        return Math.max(nextValue, head.data);
    }
    Node compute(Node head) {
        dfs(head);
        return head;
    }
}