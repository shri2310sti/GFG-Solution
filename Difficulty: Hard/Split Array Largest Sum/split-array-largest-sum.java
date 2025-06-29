class Solution {
    public int splitArray(int[] arr, int k) {
        int low = 0, high = 0;
        
        for (int num : arr) {
            low = Math.max(low, num); // at least one element
            high += num; // total sum if one group
        }
        
        int result = high;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (canSplit(arr, k, mid)) {
                result = mid; // try a smaller max
                high = mid - 1;
            } else {
                low = mid + 1; // need bigger max sum
            }
        }
        
        return result;
    }
    
    private boolean canSplit(int[] arr, int k, int maxAllowedSum) {
        int count = 1, currentSum = 0;
        
        for (int num : arr) {
            if (currentSum + num > maxAllowedSum) {
                count++; // start a new subarray
                currentSum = num;
                
                if (count > k) return false;
            } else {
                currentSum += num;
            }
        }
        
        return true;
    }
}
