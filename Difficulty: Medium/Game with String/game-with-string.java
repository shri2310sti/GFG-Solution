import java.util.*;

class Solution {
    public int minValue(String s, int k) {
        // Frequency map
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Max heap to store frequencies
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freq) {
            if (f > 0) maxHeap.add(f);
        }

        // Remove k characters, always reducing the highest frequency
        while (k > 0 && !maxHeap.isEmpty()) {
            int top = maxHeap.poll();
            top--;
            k--;
            if (top > 0) {
                maxHeap.add(top);
            }
        }

        // Calculate the final value
        int result = 0;
        while (!maxHeap.isEmpty()) {
            int val = maxHeap.poll();
            result += val * val;
        }

        return result;
    }
}
