class Solution {
    public int maxArea(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[] height = new int[m];
        int ans = 0;

        for (int i = 0; i < n; i++) {

            // Build histogram for current row
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }

            // Copy and sort in descending order
            int[] sortedHeight = height.clone();

            Arrays.sort(sortedHeight);

            // Equivalent to greater<int>() in C++
            for (int j = 0; j < m; j++) {
                int h = sortedHeight[m - 1 - j];
                ans = Math.max(ans, h * (j + 1));
            }
        }

        return ans;
    }
}