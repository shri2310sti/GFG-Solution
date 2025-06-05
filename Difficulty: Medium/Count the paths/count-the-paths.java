import java.util.*;

class Solution {
    public int countPaths(int[][] edges, int V, int src, int dest) {
        // Build adjacency list
        List<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
        }
        
        // Initialize memoization array
        long[] dp = new long[V];
        Arrays.fill(dp, -1);
        
        // Run DFS with memoization
        return (int) dfs(src, dest, adj, dp);
    }
    
    private long dfs(int u, int dest, List<Integer>[] adj, long[] dp) {
        // Base case: reached destination
        if (u == dest) {
            return 1;
        }
        
        // Return cached result if available
        if (dp[u] != -1) {
            return dp[u];
        }
        
        // Compute paths from u to dest
        long paths = 0;
        for (int v : adj[u]) {
            paths += dfs(v, dest, adj, dp);
        }
        
        // Cache and return result
        return dp[u] = paths;
    }
}