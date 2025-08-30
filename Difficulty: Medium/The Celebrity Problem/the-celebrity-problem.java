

// User function Template for Java

class Solution {
    public int celebrity(int[][] mat) {
        int n = mat.length;
        
        // Step 1: Find potential candidate
        int left = 0;
        int right = n - 1;
        
        while (left < right) {
            if (mat[left][right] == 1) {
                left++; // left knows right, so left can't be a celebrity
            } else {
                right--; // right doesn't know left, so right can't be a celebrity
            }
        }
        
        int candidate = right; // or left, both will be the same after the loop
        
        // Step 2: Validate candidate
        for (int i = 0; i < n; i++) {
            if (i != candidate && (mat[i][candidate] == 0 || mat[candidate][i] == 1)) {
                return -1; // candidate doesn't satisfy celebrity conditions
            }
        }
        
        return candidate;
    }
}