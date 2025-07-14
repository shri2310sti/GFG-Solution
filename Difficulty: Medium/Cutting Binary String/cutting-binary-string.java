import java.util.*;

class Solution {
    public int cuts(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n] = 0; // base case: no cuts needed beyond end

        Set<Long> powerOfFives = getPowerOfFives();

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') continue; // no leading zeros
            long num = 0;
            for (int j = i; j < n; j++) {
                num = num * 2 + (s.charAt(j) - '0');
                if (powerOfFives.contains(num) && dp[j + 1] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[j + 1]);
                }
            }
        }

        return dp[0] == Integer.MAX_VALUE ? -1 : dp[0];
    }

    private Set<Long> getPowerOfFives() {
        Set<Long> set = new HashSet<>();
        long power = 1;
        while (power <= (1L << 30)) {
            set.add(power);
            power *= 5;
        }
        return set;
    }
}
