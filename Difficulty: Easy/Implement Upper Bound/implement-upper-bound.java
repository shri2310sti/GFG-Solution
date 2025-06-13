class Solution {
    int upperBound(int[] arr, int target) {
        // code here
        int low = 0, high = arr.length - 1;
        int ans = arr.length;
        while(low <= high){
            int mid = (high + low) / 2;
            if(target < arr[mid]) {
                 ans = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return ans;
    }
}
