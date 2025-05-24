class Solution {
    public static int sumSubstrings(String s) {
        int n = s.length();
        int mod = Integer.MAX_VALUE; // because total fits in 32-bit signed int
        long res = 0;
        long prev = 0;

        for (int i = 0; i < n; i++) {
            int num = s.charAt(i) - '0';
            prev = prev * 10 + (long)(i + 1) * num;
            res += prev;
        }

        return (int) res;
    }
}
