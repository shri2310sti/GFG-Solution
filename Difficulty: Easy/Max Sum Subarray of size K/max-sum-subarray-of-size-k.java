class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        // Code here
        int sum = 0;
        for(int i = 0; i<k; i++){
            sum += arr[i];
        }
        
        int ans = sum;
        
        for(int i = k ; i<arr.length; i++){
            sum = sum + arr[i] - arr[i-k];
            
            if(ans < sum){
                ans = sum;
            }
        }
        return ans;
    }
}