//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.articulationPoints(V, edges);
            Collections.sort(ans);
            for (int val : ans) {
                System.out.print(val + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        ArrayList<Integer>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) graph[i] = new ArrayList<>();

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        int[] disc = new int[V];
        int[] low = new int[V];
        int[] parent = new int[V];
        boolean[] visited = new boolean[V];
        boolean[] ap = new boolean[V];  // articulation point
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        Arrays.fill(parent, -1);

        int time = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, time, disc, low, parent, visited, ap, graph);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (ap[i]) res.add(i);
        }

        if (res.isEmpty()) res.add(-1);
        return res;
    }

    private static void dfs(int u, int time, int[] disc, int[] low, int[] parent,
                            boolean[] visited, boolean[] ap, ArrayList<Integer>[] graph) {
        visited[u] = true;
        disc[u] = low[u] = ++time;
        int children = 0;

        for (int v : graph[u]) {
            if (!visited[v]) {
                children++;
                parent[v] = u;
                dfs(v, time, disc, low, parent, visited, ap, graph);

                // update low value after visiting child
                low[u] = Math.min(low[u], low[v]);

                // Rule 1: root of DFS tree with 2+ children
                if (parent[u] == -1 && children > 1) {
                    ap[u] = true;
                }

                // Rule 2: not root, and low[v] >= disc[u]
                if (parent[u] != -1 && low[v] >= disc[u]) {
                    ap[u] = true;
                }
            } else if (v != parent[u]) {
                // back edge
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}
