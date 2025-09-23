class Solution {
    public void reverseQueue(Queue<Integer> q) {
        // code here
        Stack<Integer> st = new Stack<>();
        
        // putting inside stack
        while(!q.isEmpty()){
            st.push(q.poll());
        }
        
        // now due to stack property
        // the elements offered to q will be reversed
        while(!st.isEmpty()){
            q.offer(st.pop());
        }
    }
}