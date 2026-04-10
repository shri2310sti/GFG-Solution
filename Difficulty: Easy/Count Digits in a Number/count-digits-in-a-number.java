class Solution {
    public static int countDigits(int n) {
        // Code here
        int count = 0;
        while(n>0){
            int digit = n%10;
            n/=10;
            count++;
        }
        return count;
    }
}
