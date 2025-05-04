//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String str = br.readLine();

            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java



class Solution {
    public int findSubString(String str) {
        int n = str.length();
        if (n == 0) return 0;

        // Step 1: Count unique characters
        Set<Character> uniqueChars = new HashSet<>();
        for (char c : str.toCharArray()) {
            uniqueChars.add(c);
        }
        int required = uniqueChars.size();

        // Step 2: Use a sliding window
        int[] freq = new int[256]; // For ASCII chars
        int left = 0, minLen = Integer.MAX_VALUE, count = 0;

        for (int right = 0; right < n; right++) {
            char rChar = str.charAt(right);
            freq[rChar]++;

            // Count only when a char is added for the first time
            if (freq[rChar] == 1) {
                count++;
            }

            // If window contains all unique characters
            while (count == required) {
                // Update minLen
                minLen = Math.min(minLen, right - left + 1);

                // Try to shrink from the left
                char lChar = str.charAt(left);
                freq[lChar]--;
                if (freq[lChar] == 0) {
                    count--;
                }
                left++;
            }
        }

        return minLen;
    }
}
