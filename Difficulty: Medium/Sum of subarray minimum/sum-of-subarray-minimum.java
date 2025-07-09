import java.util.*;

class Solution {
    public int sumSubMins(int[] arr) {
        int n = arr.length;
        int mod = (int)1e9 + 7;
        Stack<Integer> stack = new Stack<>();
        
        int[] prevLess = new int[n];
        int[] nextLess = new int[n];
        
        // Previous Less Element
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            prevLess[i] = stack.isEmpty() ? i : i - stack.peek() - 1;
            stack.push(i);
        }
        
        stack.clear();

        // Next Less or Equal Element
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nextLess[i] = stack.isEmpty() ? n - i - 1 : stack.peek() - i - 1;
            stack.push(i);
        }
        
        long sum = 0;
        for (int i = 0; i < n; i++) {
            long count = (long)(prevLess[i] + 1) * (nextLess[i] + 1);
            sum = (sum + arr[i] * count) % mod;
        }
        
        return (int)sum;
    }
}
