//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String digits = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.countWays(digits);
            out.println(ans);

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public int countWays(String digits) {
        int n = digits.length();
        if (n == 0 || digits.charAt(0) == '0') return 0;

        int MOD = 1_000_000_007;
        int prev2 = 1, prev1 = 1; // Corresponds to dp[i-2] and dp[i-1]

        for (int i = 2; i <= n; i++) {
            int curr = 0;
            char single = digits.charAt(i - 1);
            char pairFirst = digits.charAt(i - 2);
            
            // Single digit check
            if (single >= '1' && single <= '9') {
                curr = prev1;
            }
            
            // Two-digit check
            int twoDigit = (pairFirst - '0') * 10 + (single - '0');
            if (pairFirst != '0' && twoDigit >= 10 && twoDigit <= 26) {
                curr = (curr + prev2) % MOD;
            }

            // Update variables
            prev2 = prev1;
            prev1 = curr;
        }
        
        return prev1;
    }
}
