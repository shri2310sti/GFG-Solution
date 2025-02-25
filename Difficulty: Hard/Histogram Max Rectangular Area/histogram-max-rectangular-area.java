//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends


class Solution {
    public static int getMaxArea(int arr[]) {
        int n = arr.length;
        int[] left = new int[n];  // Stores nearest smaller to left
        int[] right = new int[n]; // Stores nearest smaller to right
        Stack<Integer> stack = new Stack<>();
        
        // Finding nearest smaller element on the left
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            left[i] = (stack.isEmpty()) ? -1 : stack.peek();
            stack.push(i);
        }

        // Clear stack for next computation
        stack.clear();

        // Finding nearest smaller element on the right
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            right[i] = (stack.isEmpty()) ? n : stack.peek();
            stack.push(i);
        }

        // Compute maximum area
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1;
            int area = arr[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}




//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int res = obj.getMaxArea(arr);

            System.out.println(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends