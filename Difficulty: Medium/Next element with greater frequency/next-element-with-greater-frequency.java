import java.util.*;

class Solution {
    public ArrayList<Integer> findGreater(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>(Collections.nCopies(n, -1));
        Map<Integer, Integer> freq = new HashMap<>();

        // Step 1: Count frequency of each element
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        Stack<Integer> stack = new Stack<>();

        // Step 2: Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Remove elements with freq <= current element's freq
            while (!stack.isEmpty() && freq.get(stack.peek()) <= freq.get(arr[i])) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                res.set(i, stack.peek());
            }

            stack.push(arr[i]);
        }

        return res;
    }
}
