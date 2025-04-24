//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            Solution ob = new Solution();
            int ans = ob.getSingle(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int getSingle(int[] arr) {
        int result = 0;
        
        // Loop through 32 bits
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            int x = (1 << i);  // Mask to check ith bit
            
            for (int num : arr) {
                if ((num & x) != 0) {
                    sum += 1;
                }
            }

            // If sum is not divisible by 3, that bit is set in the unique number
            if (sum % 3 != 0) {
                result |= x;
            }
        }

        return result;
    }
}
