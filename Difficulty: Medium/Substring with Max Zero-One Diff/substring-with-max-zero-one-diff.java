class Solution {
    int maxSubstring(String s) {
        // code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        // TC : O(N)
        // SC : O(1)
        for (char ch : s.toCharArray()) {
            currentSum += (ch == '0' ? 1 : -1);
            maxSum = Math.max(maxSum, currentSum);
            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return maxSum;
    }
}