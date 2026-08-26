class Solution {
     public boolean isNegativeWeightCycle(int V, int[][] edges) {
         // code here
         List<List<int[]>> graph = new ArrayList<>();
         for(int i=0;i<V;i++) {
             List<int[]> adj = new ArrayList<>();
             graph.add(adj);
         }

         for(int[] edge : edges) {
             int src = edge[0];
             int dest = edge[1];
             int wt = edge[2];
             graph.get(src).add(new int[]{dest, wt});
         }

         boolean[] visited = new boolean[V];
         boolean[] recStack = new boolean[V];
         for(int i=0;i<V;i++) {
             if(!visited[i]) {
                 if(isNegativeCyclePresent(graph, i, 0, visited, recStack)) return true;
             }
         }

         return false;
     }

     private boolean isNegativeCyclePresent(List<List<int[]>> graph, int src, int cycleWt, boolean[] visited, boolean[] recStack) {
         visited[src] = true;
         recStack[src] = true;
         // if(cycleWt<0) return true;
         for(int[] adj : graph.get(src)) {
             int neighbour = adj[0];
             int edgeWt = adj[1];
             if(recStack[neighbour]) {
                 if(cycleWt + edgeWt<0) return true;
                 continue;
             }
             else if(visited[neighbour]) continue;
             else {
                 if(isNegativeCyclePresent(graph, neighbour, cycleWt+edgeWt, visited, recStack)) {
                     return true;
                 }
             }
         }

         recStack[src] = false;
         return false;
     }
 }