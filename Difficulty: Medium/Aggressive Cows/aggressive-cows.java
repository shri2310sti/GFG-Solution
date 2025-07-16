// User function Template for Java
class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls);
        int ans = 0;
        for(int i = 1 ; i <= (stalls[stalls.length - 1] - stalls[0]); i++){
            if(canwePlace(stalls, k, i)){
                ans = i;
            } else return ans;
        }
        return ans;
    }
    private static boolean canwePlace(int[] stalls, int k, int distance){
        int cnt = 1;
        int last = stalls[0];
        
        for(int i = 1; i < stalls.length; i++){
            if((stalls[i] - last) >= distance){
                cnt ++;
                last = stalls[i];
            }
            
        }
        if(cnt >= k) return true;
        else return false;
    }
}