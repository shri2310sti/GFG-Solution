
class Solution {

    public String compress(String s) {
        int n = s.length();
        char[] a = s.toCharArray();
        int[] lps = buildLps(a);

        StringBuilder out = new StringBuilder(n);
        int i = n - 1;
        while (i > 0) {
            int len = i + 1;
            if ((len & 1) == 0 && canStar(lps[i], len)) {
                out.append('*');
                i = (len >> 1) - 1;
            } else {
                out.append(a[i]);
                i--;
            }
        }
        out.append(a[0]);
        return out.reverse().toString();
    }

    private boolean canStar(int suffix, int len) {
        if (suffix * 2 < len) {
            return false;
        }
        int period = len - suffix;
        return len % period == 0 && ((len / period) & 1) == 0;
    }

    private int[] buildLps(char[] a) {
        int n = a.length;
        int[] lps = new int[n];
        int len = 0;
        for (int i = 1; i < n; ) {
            if (a[i] == a[len]) {
                lps[i++] = ++len;
            } else if (len != 0) {
                len = lps[len - 1];
            } else {
                lps[i++] = 0;
            }
        }
        return lps;
    }
}