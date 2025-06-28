// User function Template for Java
class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls);
        
        for(int i = 1; i <= (stalls[stalls.length - 1] - stalls[0]); i++){
            if(canwePlaced(stalls, k, i) == true) continue;
            else return i-1;
        }
        return stalls[stalls.length - 1] - stalls[0];
    }
    static boolean canwePlaced(int[] stalls, int cows, int distance){
        int n = stalls.length;
        int cntCows = 1;
        int last = stalls[0];
        for(int i = 1; i < stalls.length; i++){
            if(stalls[i] - last >= distance){
                cntCows++;
                last = stalls[i];
            } 
            
        }
        if(cntCows >= cows) return true;
        else return false;
    }
}