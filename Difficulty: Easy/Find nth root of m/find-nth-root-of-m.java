// User function Template for Java

class Solution {
    public int nthRoot(int n, int m) {
        // code here
        int low = 1, high = m;
        while(low <= high){
            int mid = (low + high)/2;
            if(func(n, mid) == m) return mid;
            else if(func(n, mid) > m ) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }
    public static int func(int n, int mid){
        int result = mid;
        for(int i = 0; i < n-1; i++){
            result = result * mid;
        }
        return result;
    }
}