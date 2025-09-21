




class Solution {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        int n = arr.length;
        int[] result = new int[n + 1];
        int[] left = new int[n];  // Stores the previous smaller element index
        int[] right = new int[n]; // Stores the next smaller element index
        Arrays.fill(right, n);    // Default value as n (out of bounds)
        Arrays.fill(left, -1);    // Default value as -1 (out of bounds)
        
        Stack<Integer> stack = new Stack<>();
        
        // Compute left[] and right[] in a single pass
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                right[stack.pop()] = i; // Update right boundary for the previous element
            }
            if (!stack.isEmpty()) {
                left[i] = stack.peek();
            }
            stack.push(i);
        }
        
        // Compute maximum of minimums
        for (int i = 0; i < n; i++) {
            int windowSize = right[i] - left[i] - 1;
            result[windowSize] = Math.max(result[windowSize], arr[i]);
        }
        
        // Fill in missing values from right to left
        for (int i = n - 1; i >= 1; i--) {
            result[i] = Math.max(result[i], result[i + 1]);
        }
        
        // Convert to ArrayList for output
        ArrayList<Integer> resList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            resList.add(result[i]);
        }
        
        return resList;
    }
}

