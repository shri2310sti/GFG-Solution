//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] edge = new int[n][2];
            for (int i = 0; i < n; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res = obj.minCost(edge);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends





class Solution {

    public int minCost(int[][] houses) {
        int n = houses.length;
        boolean[] visited = new boolean[n];
        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[0] = 0;

        int result = 0;

        for (int i = 0; i < n; i++) {
            int u = -1;
            int min = Integer.MAX_VALUE;

            // Find the unvisited node with the smallest cost
            for (int j = 0; j < n; j++) {
                if (!visited[j] && minCost[j] < min) {
                    min = minCost[j];
                    u = j;
                }
            }

            // Add the selected node to the MST
            visited[u] = true;
            result += minCost[u];

            // Update minCost for all unvisited neighbors
            for (int v = 0; v < n; v++) {
                if (!visited[v]) {
                    int dist = Math.abs(houses[u][0] - houses[v][0]) +
                               Math.abs(houses[u][1] - houses[v][1]);
                    if (dist < minCost[v]) {
                        minCost[v] = dist;
                    }
                }
            }
        }

        return result;
    }
}
