//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            ArrayList<String> ans = obj.findPermutation(S);
            Collections.sort(ans);
            for (int i = 0; i < ans.size(); i++) {
                out.print(ans.get(i) + " ");
            }
            out.println();

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends



class Solution {
    public ArrayList<String> findPermutation(String s) {
        ArrayList<String> result = new ArrayList<>();
        HashSet<String> uniquePermutations = new HashSet<>();
        char[] chars = s.toCharArray();
        boolean[] used = new boolean[chars.length];

        // Sort the characters to help with avoiding duplicate permutations
        java.util.Arrays.sort(chars);

        backtrack(chars, new StringBuilder(), used, uniquePermutations);

        // Add all unique permutations to the result
        result.addAll(uniquePermutations);
        return result;
    }

    private void backtrack(char[] chars, StringBuilder current, boolean[] used, HashSet<String> uniquePermutations) {
        // If the current length equals the input string length, add it to the set
        if (current.length() == chars.length) {
            uniquePermutations.add(current.toString());
            return;
        }

        // Iterate through the characters
        for (int i = 0; i < chars.length; i++) {
            // Skip used characters or duplicates (when the previous identical character was not used)
            if (used[i] || (i > 0 && chars[i] == chars[i - 1] && !used[i - 1])) {
                continue;
            }

            // Mark the character as used and add it to the current permutation
            used[i] = true;
            current.append(chars[i]);

            // Recur to build the next part of the permutation
            backtrack(chars, current, used, uniquePermutations);

            // Backtrack by removing the last character and marking it as unused
            current.deleteCharAt(current.length() - 1);
            used[i] = false;
        }
    }
}
