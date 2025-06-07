class Solution {
    public int longestCommonSum(int[] a1, int[] a2) {
        int n = a1.length;
        int[] diff = new int[n];
        
        // Compute difference array
        for (int i = 0; i < n; i++) {
            diff[i] = a1[i] - a2[i];
        }
        
        // Use hash map to store prefix sums and their earliest indices
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int maxLength = 0;
        
        // Initialize map with prefix sum 0 at index -1 for subarrays starting from 0
        map.put(0, -1);
        
        // Iterate through the difference array
        for (int i = 0; i < n; i++) {
            prefixSum += diff[i];
            
            // If prefix sum exists in map, we found a subarray with sum 0
            if (map.containsKey(prefixSum)) {
                maxLength = Math.max(maxLength, i - map.get(prefixSum));
            }
            
            // Store the earliest occurrence of this prefix sum
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
        }
        
        return maxLength;
    }
}