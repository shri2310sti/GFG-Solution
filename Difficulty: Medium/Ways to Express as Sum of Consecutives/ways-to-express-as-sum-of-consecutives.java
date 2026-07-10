class Solution {
    public int getCount(int n) {
        int count = 0;
        for (int k = 2; k * (k + 1) / 2 <= n; k++) {
            int numerator = n - (k * (k - 1)) / 2;           
            if (numerator % k == 0) {
                int a = numerator / k;
                if (a > 0) {
                    count++;
                }
            }
        }        
        return count;
    }
}
