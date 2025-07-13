import java.util.*;

class Solution {
    public int nonLisMaxSum(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int totalSum = arr[0];
        int lisLength = 1;

        // Step 1: Compute LIS length using DP
        for (int i = 1; i < n; i++) {
            totalSum += arr[i];
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            lisLength = Math.max(lisLength, dp[i]);
        }

        // Step 2: Subtract elements from one LIS (right to left)
        int currMax = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (dp[i] == lisLength && arr[i] < currMax) {
                totalSum -= arr[i];
                currMax = arr[i];
                lisLength--;
            }
        }

        return totalSum;
    }
}
