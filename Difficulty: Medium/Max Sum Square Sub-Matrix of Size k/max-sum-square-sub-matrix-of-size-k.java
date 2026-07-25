  class Solution {

    public int maximumSum(int[][] mat, int k) {

        int n = mat.length;

        int maxGlobal = Integer.MIN_VALUE;

 

        // Step 1: Compress every continuous block of k rows into a 1D array

        for (int i = 0; i <= n - k; i++) {

            // colSums[j] will store the sum of mat[row][j] for row from i to i+k-1

            int[] colSums = new int[n];

            

            for (int r = i; r < i + k; r++) {

                for (int j = 0; j < n; j++) {

                    colSums[j] += mat[r][j];

                }

            }

 

            // Step 2: Use a sliding window of size k over the 1D colSums array

            int currentSubgridSum = 0;

            for (int j = 0; j < k; j++) {

                currentSubgridSum += colSums[j];

            }

            maxGlobal = Math.max(maxGlobal, currentSubgridSum);

 

            for (int j = k; j < n; j++) {

                currentSubgridSum += colSums[j] - colSums[j - k];

                maxGlobal = Math.max(maxGlobal, currentSubgridSum);

            }

        }

 

        return maxGlobal;

    }

}

