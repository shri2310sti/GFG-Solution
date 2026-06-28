class Solution {

    public int maxDotProduct(int a[], int b[]) {

        int n = a.length;

        int m = b.length;

        

        // Since we only need values from the previous row (i-1), 

        // we can optimize space from O(N*M) to O(M).

        int[] dp = new int[m + 1];

        

        for (int i = 1; i <= n; i++) {

            // Keep track of the diagonal value dp[i-1][j-1]

            int prevDiagonal = dp[0]; 

            

            for (int j = 1; j <= m; j++) {

                // Store the current dp[j] before it gets overwritten

                int temp = dp[j]; 

                

                if (i == j) {

                    dp[j] = a[i - 1] * b[j - 1] + prevDiagonal;

                } else if (i > j) {

                    dp[j] = Math.max(a[i - 1] * b[j - 1] + prevDiagonal, dp[j]);

                }

                

                // Update prevDiagonal for the next iteration of 'j'

                prevDiagonal = temp; 

            }

        }

        

        return dp[m];

    }

}

 