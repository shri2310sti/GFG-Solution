class Solution {
    public int maxPeople(int[] arr) {
        // code here
        int n=arr.length;
        int[] nge=new int[n];
        int[] pge=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.empty() && arr[st.peek()]<arr[i]){
                st.pop();
            }
            pge[i]=st.empty() ? -1:st.peek();
            st.push(i);
        }
        st.clear();
        for(int i=n-1;i>=0;i--){
            while(!st.empty() && arr[st.peek()]<arr[i]){
                st.pop();
            }
            nge[i]=st.empty() ? n:st.peek();
            st.push(i);
        }
        
        int maxpeople=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int people=nge[i]-pge[i]-1;
            maxpeople=Math.max(maxpeople,people);
        }
        return maxpeople;
    }
}

