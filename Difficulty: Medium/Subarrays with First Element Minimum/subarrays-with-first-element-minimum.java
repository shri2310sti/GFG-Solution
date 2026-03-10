class Solution {
    public int countSubarrays(int[] arr) {
        // code here
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] NSE = new int[n];
        
        for(int i = n - 1 ; i >= 0 ; i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                NSE[i] = n;
            }else{
                NSE[i] = stack.peek();
            }
            stack.push(i);
        }
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            count += (NSE[i] - i);
        }
        return count;
    }
}