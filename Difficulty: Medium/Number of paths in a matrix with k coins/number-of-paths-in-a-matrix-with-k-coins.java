class Solution {
    class Node{
        int r; int c;
        
        Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public int numberOfPath(int[][] mat, int k) {
        // code here
        int n = mat.length; int m = mat[0].length;
        @SuppressWarnings("unchecked")
        HashMap<Integer,Integer>[][] dp = (HashMap<Integer,Integer>[][]) new HashMap[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) dp[i][j] = new HashMap<>();
        }
        
        bfs(mat,n,m,dp,k);
        
        return dp[0][0].getOrDefault(k,0);
    }
    private void bfs(int[][] mat, int n, int m, HashMap<Integer,Integer>[][] dp, int k2){
        dp[n-1][m-1].put(mat[n-1][m-1],1);
        Queue<Node> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        q.add(new Node(n-1,m-1));
        
        while(!q.isEmpty()){
            int i = q.peek().r; int j = q.remove().c;
            vis[i][j] = true;
            
            for(int k : dp[i][j].keySet()){
                if(i-1 >= 0 && k2 >= k + mat[i-1][j]){
                    int val = k + mat[i-1][j];
                    int freq = dp[i][j].get(k);
                    dp[i-1][j].put(val,dp[i-1][j].getOrDefault(val,0)+freq);
                    if(!vis[i-1][j]){
                        q.add(new Node(i-1,j));
                        vis[i-1][j] = true;
                    } 
                }
                if(j-1 >= 0 && k2 >= k + mat[i][j-1]){
                    int val = k + mat[i][j-1];
                    int freq = dp[i][j].get(k);
                    dp[i][j-1].put(val,dp[i][j-1].getOrDefault(val,0)+freq);
                    if(!vis[i][j-1]){
                        q.add(new Node(i,j-1));
                        vis[i][j-1] = true;
                    } 
                }
            }
        }
    }
}