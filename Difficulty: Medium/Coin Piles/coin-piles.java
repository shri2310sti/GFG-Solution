class Solution {
    public int minimumCoins(int[] arr, int k) {
        int n = arr.length;
        // Sort the array
        Arrays.sort(arr);
        
        // Create prefix sum array
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }
        
        long minCoins = Long.MAX_VALUE;
        
        // Try each index i as the minimum pile value (x = arr[i])
        for (int i = 0; i < n; i++) {
            long x = arr[i]; // Minimum coins in any remaining pile
            // Find rightmost j such that arr[j] <= x + k
            int j = binarySearch(arr, x + k, i, n - 1);
            
            // Coins to remove:
            // 1. Sum of coins in piles [0, i-1] (fully remove piles with < x)
            long coinsToRemove = prefixSum[i];
            
            // 2. Excess coins in piles [j+1, n-1] (reduce to x + k)
            if (j < n - 1) {
                long sumAfterJ = prefixSum[n] - prefixSum[j + 1];
                long pilesAfterJ = n - j - 1;
                coinsToRemove += sumAfterJ - pilesAfterJ * (x + k);
            }
            
            minCoins = Math.min(minCoins, coinsToRemove);
        }
        
        return (int) minCoins;
    }
    
    // Binary search to find rightmost index j where arr[j] <= target
    private int binarySearch(int[] arr, long target, int left, int right) {
        int result = left - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}