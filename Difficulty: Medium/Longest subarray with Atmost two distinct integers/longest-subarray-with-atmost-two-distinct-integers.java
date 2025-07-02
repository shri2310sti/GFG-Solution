import java.util.HashMap;
import java.util.Map;

class Solution {
    public int totalElements(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < arr.length; right++) {
            countMap.put(arr[right], countMap.getOrDefault(arr[right], 0) + 1);

            // Shrink window until we have at most 2 distinct integers
            while (countMap.size() > 2) {
                countMap.put(arr[left], countMap.get(arr[left]) - 1);
                if (countMap.get(arr[left]) == 0) {
                    countMap.remove(arr[left]);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
