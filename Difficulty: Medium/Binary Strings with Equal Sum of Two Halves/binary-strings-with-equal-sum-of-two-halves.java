class Solution {
    static final long MOD = 1000000007L;

    long power(long a, long b) {
        long ans = 1;

        while (b > 0) {
            if ((b & 1) == 1) {
                ans = (ans * a) % MOD;
            }
            a = (a * a) % MOD;
            b >>= 1;
        }

        return ans;
    }

    long modInv(long x) {
        return power(x, MOD - 2);
    }

    public int computeValue(int n) {
        long ans = 1;

        for (int i = 1; i <= n; i++) {
            ans = (ans * (2L * n - i + 1)) % MOD;
            ans = (ans * modInv(i)) % MOD;
        }

        return (int) ans;
    }
}