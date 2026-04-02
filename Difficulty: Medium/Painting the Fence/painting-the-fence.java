class Solution {
    public int countWays(int n, int k) {
        int total = k;

        int same = 0, diff = k;

        for (int i = 2; i <= n; i++) {
            same = diff;

            diff = ((int)total * (k - 1));

            total = (same + diff);
        }
        return total;
    }
}