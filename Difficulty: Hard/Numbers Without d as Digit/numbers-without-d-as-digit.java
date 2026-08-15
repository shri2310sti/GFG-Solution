class Solution {
     private Integer[][][] memo;

     public int countWithout(int n, int d) {
         if (n == 0) return 0;

         String digits = String.valueOf(n);
         int len = digits.length();

         // Initialize memoization table
         memo = new Integer[len][2][2];

         return countDigitFree(0, true, false, digits, d);
     }

     private int countDigitFree(int pos, boolean tight, boolean started, String digits, int d) {
         if (pos == digits.length()) {
             return started ? 1 : 0;
         }

         int tightIdx = tight ? 1 : 0;
         int startedIdx = started ? 1 : 0;

         if (memo[pos][tightIdx][startedIdx] != null) {
             return memo[pos][tightIdx][startedIdx];
         }

         int limit = tight ? (digits.charAt(pos) - '0') : 9;
         int count = 0;

         for (int digit = 0; digit <= limit; digit++) {
             boolean newTight = tight && (digit == limit);

             if (!started && digit == 0) {
                 count += countDigitFree(pos + 1, newTight, false, digits, d);
             } else if (digit != d) {
                 count += countDigitFree(pos + 1, newTight, true, digits, d);
             }
         }

         return memo[pos][tightIdx][startedIdx] = count;
     }
 }