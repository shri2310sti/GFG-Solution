


class Solution {
    public static int countWays(String s1, String s2) {
        int MOD = 1000000007;
        int n = s1.length();
        int m = s2.length();
        
        // dp[i][j] will be storing the count of subsequences of s1[0..i-1] that are equal to s2[0..j-1]
        int[][] dp = new int[n + 1][m + 1];
        
        // Base case: An empty string s2 has exactly one subsequence in any s1, which is the empty subsequence.
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        
        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // If the characters match, we can either include the character or exclude it
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % MOD;
                } else {
                    // If the characters do not match, we can only exclude the character from s1
                    dp[i][j] = dp[i - 1][j] % MOD;
                }
            }
        }
        
        return dp[n][m];
    }
}
