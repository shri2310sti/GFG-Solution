class Solution {
    public int numberOfWays(int n) {
        // code here
        // if(n==1 || n==0)
        // {
        //     return 1;
        // }
        // if(n<0)
        // {
        //     return 0;
        // }
        // return numberOfWays(n-1)+numberOfWays(n-2);
        
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        
        if(n==1 && n==0) return 1;
        
        for(int i=2; i<n+1; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        
        return dp[n];
    }
};