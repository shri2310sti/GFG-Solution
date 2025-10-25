class Solution {
    public static int minCost(int[] arr) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int ans = 0;
        
        if(arr.length==1) return 0;
        
        for(int num:arr){
            pq.add(num);
        }
        
        while(pq.size()!=1){
            int a = pq.remove();
            int b = pq.remove();
            ans += a+b;
            pq.add(a+b);
        }
        
        return ans;
    }
}

