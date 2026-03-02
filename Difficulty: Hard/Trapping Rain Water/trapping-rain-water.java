

class Solution {
    public int maxWater(int arr[]) {
        int n = arr.length;
        if (n <= 2) {
            return 0; // Not enough blocks to trap water
        }
        
        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int waterTrapped = 0;
        
        while (left <= right) {
            if (arr[left] <= arr[right]) {
                if (arr[left] >= leftMax) {
                    leftMax = arr[left]; // Update leftMax
                } else {
                    waterTrapped += leftMax - arr[left];
                }
                left++;
            } else {
                if (arr[right] >= rightMax) {
                    rightMax = arr[right]; // Update rightMax
                } else {
                    waterTrapped += rightMax - arr[right];
                }
                right--;
            }
        }
        
        return waterTrapped;
    }
}
