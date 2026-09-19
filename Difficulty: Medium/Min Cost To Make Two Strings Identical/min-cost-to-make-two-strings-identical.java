class Solution {
    public int findMinCost(String s1, String s2, int costS1, int costS2) {
        // code here
        int n = s1.length();
                int m = s2.length();

                int[][] dp = new int[n + 1][m + 1];

                // Maximum cost saved by keeping common characters
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= m; j++) {

                        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                            dp[i][j] = dp[i - 1][j - 1] + costS1 + costS2;
                        } else {
                            dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                        }
                    }
                }

                // Cost of deleting all characters
                int totalCost = n * costS1 + m * costS2;

                // Remove the cost saved by keeping common subsequence
                return totalCost - dp[n][m];
    }
}