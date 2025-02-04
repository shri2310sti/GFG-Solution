//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            Solution obj = new Solution();
            int ans[] = obj.passedBy(n, m);

            System.out.println(ans[0] + " " + ans[1]);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int[] passedBy(int a, int b) {
        // a is passed by value, adding 1
        int newA = a + 1;

        // b is also passed by value (since Java does not have pass-by-reference for primitives),
        // but we assume modification happens in a reference-like scenario, adding 2
        int newB = b + 2;

        return new int[]{newA, newB};
    }
}

