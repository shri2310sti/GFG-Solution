
class Solution {
    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        int left = 0, maxLength = 0, startIndex = 0;
        
        Deque<Integer> minDeque = new LinkedList<>();
        Deque<Integer> maxDeque = new LinkedList<>();

        for (int right = 0; right < arr.length; right++) {
            // Maintain minDeque (stores minimum elements in window)
            while (!minDeque.isEmpty() && arr[minDeque.peekLast()] > arr[right]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(right);

            // Maintain maxDeque (stores maximum elements in window)
            while (!maxDeque.isEmpty() && arr[maxDeque.peekLast()] < arr[right]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(right);

            // Shrink window if condition is violated
            while (arr[maxDeque.peekFirst()] - arr[minDeque.peekFirst()] > x) {
                if (minDeque.peekFirst() == left) minDeque.pollFirst();
                if (maxDeque.peekFirst() == left) maxDeque.pollFirst();
                left++;
            }

            // Update max length and starting index
            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                startIndex = left;
            }
        }

        // Extract the longest subarray
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = startIndex; i < startIndex + maxLength; i++) {
            result.add(arr[i]);
        }
        return result;
    }

}
