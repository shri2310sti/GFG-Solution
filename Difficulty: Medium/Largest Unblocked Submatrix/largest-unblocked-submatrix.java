import java.util.Arrays;

class Solution {
    public int largestArea(int n, int m, int k, int[][] arr) {

        if (k == 0) {
            return n * m;
        }

        // Sort by row
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        int maxRow = 0;
        for (int i = 0; i < k - 1; i++) {
            maxRow = Math.max(maxRow, arr[i + 1][0] - arr[i][0] - 1);
        }
        maxRow = Math.max(maxRow, arr[0][0] - 1);
        maxRow = Math.max(maxRow, n - arr[k - 1][0]);

        // Sort by column
        Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));

        int maxCol = 0;
        for (int i = 0; i < k - 1; i++) {
            maxCol = Math.max(maxCol, arr[i + 1][1] - arr[i][1] - 1);
        }
        maxCol = Math.max(maxCol, arr[0][1] - 1);
        maxCol = Math.max(maxCol, m - arr[k - 1][1]);

        return maxRow * maxCol;
    }
}