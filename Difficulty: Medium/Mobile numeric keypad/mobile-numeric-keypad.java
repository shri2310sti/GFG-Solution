class Solution {
    public int getCount(int n) {
        // Adjacency list for each digit
        int[][] moves = {
            {0, 8},    // 0
            {1, 2, 4}, // 1
            {2, 1, 3, 5}, // 2
            {3, 2, 6}, // 3
            {4, 1, 5, 7}, // 4
            {5, 2, 4, 6, 8}, // 5
            {6, 3, 5, 9}, // 6
            {7, 4, 8}, // 7
            {8, 5, 7, 9, 0}, // 8
            {9, 6, 8}  // 9
        };

        // dp[i][j] = number of sequences of length i ending with digit j
        int[][] dp = new int[n + 1][10];

        // Base case: sequences of length 1
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        // Build the dp table
        for (int len = 2; len <= n; len++) {
            for (int digit = 0; digit <= 9; digit++) {
                for (int neighbor : moves[digit]) {
                    dp[len][digit] += dp[len - 1][neighbor];
                }
            }
        }

        // Total count of all sequences of length n
        int total = 0;
        for (int i = 0; i < 10; i++) {
            total += dp[n][i];
        }

        return total;
    }
}
