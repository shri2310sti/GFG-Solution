import java.util.*;

class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(n, -1));
        Stack<Integer> stack = new Stack<>();

        // Traverse twice the array (simulate circular array)
        for (int i = 2 * n - 1; i >= 0; i--) {
            int current = arr[i % n];

            // Pop elements from stack which are <= current
            while (!stack.isEmpty() && stack.peek() <= current) {
                stack.pop();
            }

            // Set result if we're in the first pass
            if (i < n) {
                if (!stack.isEmpty()) {
                    result.set(i, stack.peek());
                } else {
                    result.set(i, -1);
                }
            }

            // Push current element for future comparisons
            stack.push(current);
        }

        return result;
    }
}
