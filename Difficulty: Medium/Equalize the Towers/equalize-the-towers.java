import java.util.*;

class Solution {
    public int minCost(int[] heights, int[] cost) {
        int n = heights.length;

        // Step 1: Combine height and cost into one array
        int[][] pair = new int[n][2];
        for (int i = 0; i < n; i++) {
            pair[i][0] = heights[i];
            pair[i][1] = cost[i];
        }

        // Step 2: Sort the pairs by height
        Arrays.sort(pair, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 3: Calculate total cost
        long totalCost = 0;
        for (int i = 0; i < n; i++) {
            totalCost += pair[i][1];
        }

        // Step 4: Find the weighted median
        long half = totalCost / 2;
        long curr = 0;
        int medianHeight = 0;
        for (int i = 0; i < n; i++) {
            curr += pair[i][1];
            if (curr > half) {
                medianHeight = pair[i][0];
                break;
            }
        }

        // Step 5: Calculate total cost to convert all towers to medianHeight
        long result = 0;
        for (int i = 0; i < n; i++) {
            result += 1L * Math.abs(heights[i] - medianHeight) * cost[i];
        }

        return (int) result;
    }
}
