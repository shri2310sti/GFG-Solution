class Solution {

    public int minimumCost(int[] cost, int w) {

        int[]dp=new int[w+1];

        for(int i=0;i<w+1;i++)

        dp[i]=(int)1e5+1;

        dp[0]=0;

        int n=cost.length;

        for(int i=0;i<n;i++){

            if(cost[i]==-1){

            continue;

            }

            int wt=i+1;

        for(int cur=wt;cur<=w;cur++){

            if(dp[cur-wt]!=(int)1e5+1)

                

                dp[cur]=Math.min(dp[cur],dp[cur-wt]+cost[i]);

            

        }

        }

       return (dp[w]==(int)1e5+1)?-1:dp[w];

    }

}
