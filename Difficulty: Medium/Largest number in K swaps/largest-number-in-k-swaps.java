//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int k = sc.nextInt();
            String str = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.findMaximumNum(str, k));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    String max = "";

    // Function to find the largest number after k swaps.
    public String findMaximumNum(String s, int k) {
        max = s;
        char[] chars = s.toCharArray();
        findMaxHelper(chars, k, 0);
        return max;
    }

    private void findMaxHelper(char[] chars, int k, int index) {
        if (k == 0 || index == chars.length) return;

        int n = chars.length;
        char maxDigit = chars[index];

        // Find the maximum digit from index to end
        for (int i = index + 1; i < n; i++) {
            if (chars[i] > maxDigit) {
                maxDigit = chars[i];
            }
        }

        // Reduce k only if a swap is needed
        if (maxDigit != chars[index]) {
            k--;
        }

        // Try all candidates for swapping
        for (int i = index; i < n; i++) {
            if (chars[i] == maxDigit) {
                swap(chars, i, index);

                String current = new String(chars);
                if (current.compareTo(max) > 0) {
                    max = current;
                }

                findMaxHelper(chars, k, index + 1);

                // Backtrack
                swap(chars, i, index);
            }
        }
    }

    // Swap helper
    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
