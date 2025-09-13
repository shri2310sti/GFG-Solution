

// User function Template for Java



class Solution {
    int getMinDiff(int[] arr, int k) {
        int n = arr.length;
        if (n == 1) {
            return 0; // No difference if there's only one tower
        }
        
        // Step 1: Sort the array
        Arrays.sort(arr);
        
        // Step 2: Initialize the result with the difference between the max and min heights without any modification
        int result = arr[n - 1] - arr[0];
        
        // Step 3: Initialize the smallest and largest possible heights after modification
        int smallest = arr[0] + k; // Smallest tower increased by k
        int largest = arr[n - 1] - k; // Largest tower decreased by k
        
        // Step 4: Iterate through the array and adjust min and max heights
        for (int i = 0; i < n - 1; i++) {
            int minTower = Math.min(smallest, arr[i + 1] - k); // Min height from smallest or reducing next tower
            int maxTower = Math.max(largest, arr[i] + k); // Max height from largest or increasing current tower
            
            // Ensure we are not introducing negative heights
            if (minTower < 0) {
                continue;
            }
            
            // Step 5: Update the result with the minimum difference
            result = Math.min(result, maxTower - minTower);
        }
        
        return result;
    }
}

