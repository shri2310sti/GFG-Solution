class Solution {
    public int maxGold(int[][] mat) {
        int n = mat.length;        // number of rows
        int m = mat[0].length;     // number of columns
        
        int[][] dp = new int[n][m];
        
        // Initialize first column
        for (int i = 0; i < n; i++) {
            dp[i][0] = mat[i][0];
        }
        
        // Fill the dp table
        for (int j = 1; j < m; j++) {
            for (int i = 0; i < n; i++) {
                int left = dp[i][j - 1];
                int leftUp = (i > 0) ? dp[i - 1][j - 1] : 0;
                int leftDown = (i < n - 1) ? dp[i + 1][j - 1] : 0;
                
                dp[i][j] = mat[i][j] + Math.max(left, Math.max(leftUp, leftDown));
            }
        }
        
        // Find the maximum value in the last column
        int maxGold = 0;
        for (int i = 0; i < n; i++) {
            maxGold = Math.max(maxGold, dp[i][m - 1]);
        }
        
        return maxGold;
    }
}
