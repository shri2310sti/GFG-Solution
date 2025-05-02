//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            int ans = new Solution().findMaximum(arr);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findMaximum(int[] arr) {
        int left = 0, right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Handle boundary cases safely
            if (mid > 0 && mid < arr.length - 1) {
                if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                    return arr[mid]; // Bitonic point
                } else if (arr[mid] > arr[mid - 1]) {
                    left = mid + 1; // Move right
                } else {
                    right = mid - 1; // Move left
                }
            } else if (mid == 0) {
                return Math.max(arr[0], arr[1]);
            } else if (mid == arr.length - 1) {
                return Math.max(arr[arr.length - 1], arr[arr.length - 2]);
            }
        }
        
        return -1; // Should never reach here as one bitonic point is guaranteed
    }
}
