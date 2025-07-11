class Solution {
    public int countConsec(int n) {
        int total = 1 << n; 
        
        int[] a = new int[n + 1]; // ends with 0
        int[] b = new int[n + 1]; // ends with 1

        // Base cases
        a[1] = 1; // "0"
        b[1] = 1; // "1"

        for (int i = 2; i <= n; i++) {
            a[i] = a[i - 1] + b[i - 1];
            b[i] = a[i - 1];
        }

        int noConsecOnes = a[n] + b[n];

        return total - noConsecOnes;
    }
}
