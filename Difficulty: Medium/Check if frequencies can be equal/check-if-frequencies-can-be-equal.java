import java.util.*;

class Solution {
    boolean sameFreq(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        
        // Count frequency of each character
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        
        // Count how many times each frequency occurs
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int freq : freqMap.values()) {
            countMap.put(freq, countMap.getOrDefault(freq, 0) + 1);
        }
        
        // If all frequencies are same
        if (countMap.size() == 1) return true;

        // If more than 2 frequencies → not possible
        if (countMap.size() > 2) return false;
        
        // When there are exactly two frequencies
        List<Integer> keys = new ArrayList<>(countMap.keySet());
        int f1 = keys.get(0), f2 = keys.get(1);
        int c1 = countMap.get(f1), c2 = countMap.get(f2);

        // Case 1: One of the frequencies is 1 and occurs only once
        if ((f1 == 1 && c1 == 1) || (f2 == 1 && c2 == 1)) return true;

        // Case 2: Difference between frequencies is 1 and higher one occurs once
        if ((Math.abs(f1 - f2) == 1) && ((f1 > f2 && c1 == 1) || (f2 > f1 && c2 == 1))) return true;

        return false;
    }
}
