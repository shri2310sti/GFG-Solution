

// User function Template for Java

class Solution {
    // Function to count the number of possible triangles.
    static int countTriangles(int arr[]) {
        int n = arr.length;
        if (n < 3) return 0; // Not enough sides to form a triangle
        
        // Sort the array
        Arrays.sort(arr);
        int count = 0;
        
        // Fix the third side
        for (int k = n - 1; k >= 2; k--) {
            int i = 0;          // First pointer
            int j = k - 1;      // Second pointer
            
            // Find valid pairs
            while (i < j) {
                if (arr[i] + arr[j] > arr[k]) {
                    // If arr[i] + arr[j] > arr[k], then all pairs (i, i+1, ..., j) are valid
                    count += (j - i);
                    j--; // Move the second pointer left
                } else {
                    i++; // Move the first pointer right
                }
            }
        }
        
        return count;
    }
    
}