


class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> span = new ArrayList<>(n);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // Pop elements that are smaller or equal to arr[i]
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }

            // If stack is empty, all previous elements are smaller, so span = i + 1
            if (stack.isEmpty()) {
                span.add(i + 1);
            } else {
                // Otherwise, span is difference between indices
                span.add(i - stack.peek());
            }

            // Push current index onto the stack
            stack.push(i);
        }
        return span;
    }

    
}
