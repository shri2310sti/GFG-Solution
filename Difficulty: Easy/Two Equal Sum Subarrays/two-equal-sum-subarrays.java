

class Solution {
    public boolean canSplit(int arr[]) {
        int totalSum = 0;
        
        // Calculate the total sum of the array
        for (int num : arr) {
            totalSum += num;
        }
        
        int leftSum = 0;
        
        // Traverse the array and check for possible split
        for (int i = 0; i < arr.length; i++) {
            leftSum += arr[i];
            
            // Check if leftSum equals the sum of the right subarray
            if (leftSum == totalSum - leftSum) {
                return true;
            }
        }
        
        return false;  // No such split exists
    }
}
