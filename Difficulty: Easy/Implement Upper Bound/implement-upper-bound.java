class Solution {
    int upperBound(int[] arr, int target) {
        // code here
        int low = 0, high = arr.length - 1;
        int ans = arr.length;
        
        while(low <= high){
            
            int mid = (low + high) / 2;
            
            if(arr[mid] > target){
                ans = mid;
                high = mid-1;
            }
            else low = mid + 1;
        }
        return ans;
    }
}
