
class Solution {
    static int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        Map<Integer, Integer> firstOccurrence = new HashMap<>();
        int prefixSum = 0;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            // Convert value based on comparison with k
            int val = (arr[i] > k) ? 1 : -1;
            prefixSum += val;

            if (prefixSum > 0) {
                // Whole subarray [0...i] is valid
                maxLen = i + 1;
            } else {
                // Check if (prefixSum - 1) was seen before
                if (firstOccurrence.containsKey(prefixSum - 1)) {
                    maxLen = Math.max(maxLen, i - firstOccurrence.get(prefixSum - 1));
                }
            }

            // Store first occurrence of this prefixSum
            if (!firstOccurrence.containsKey(prefixSum)) {
                firstOccurrence.put(prefixSum, i);
            }
        }

        return maxLen;
    }
}



