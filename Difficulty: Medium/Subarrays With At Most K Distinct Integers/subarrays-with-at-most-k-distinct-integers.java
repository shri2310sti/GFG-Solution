import java.util.*;

class Solution {
    public int countAtMostK(int[] arr, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0, count = 0;

        for (int right = 0; right < arr.length; right++) {
            freq.put(arr[right], freq.getOrDefault(arr[right], 0) + 1);

            if (freq.get(arr[right]) == 1) {
                k--; // New unique element
            }

            while (k < 0) {
                freq.put(arr[left], freq.get(arr[left]) - 1);
                if (freq.get(arr[left]) == 0) {
                    k++; // One unique removed
                }
                left++;
            }

            count += right - left + 1;
        }

        return count;
    }
}
