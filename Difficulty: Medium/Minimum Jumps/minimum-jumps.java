

class Solution {
    static int minJumps(int[] arr) {
        int n = arr.length;
        if (n == 1) return 0;  // Already at the last index
        if (arr[0] == 0) return -1;  // Cannot move at all
        
        int maxReach = arr[0], steps = arr[0], jumps = 1;
        
        for (int i = 1; i < n; i++) {
            if (i == n - 1) return jumps;  // Reached the last index
            
            maxReach = Math.max(maxReach, i + arr[i]); // Update maxReach
            steps--;  // Use a step
            
            if (steps == 0) {  // Need to jump
                jumps++;
                if (i >= maxReach) return -1; // Cannot progress further
                steps = maxReach - i;  // Reset steps
            }
        }
        return -1;
    }
}
