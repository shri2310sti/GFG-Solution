import java.util.*;

class Solution {
    public int substrCount(String s, int k) {
        if (s.length() < k) return 0;
        
        int count = 0;
        int[] freq = new int[26]; // since only lowercase letters
        int distinct = 0;

        for (int i = 0; i < s.length(); i++) {
            // Add new character
            int idx = s.charAt(i) - 'a';
            freq[idx]++;
            if (freq[idx] == 1) distinct++;

            // Remove old character if window size > k
            if (i >= k) {
                int removeIdx = s.charAt(i - k) - 'a';
                freq[removeIdx]--;
                if (freq[removeIdx] == 0) distinct--;
            }

            // Check valid substring
            if (i >= k - 1 && distinct == k - 1) {
                count++;
            }
        }
        return count;
    }
}
