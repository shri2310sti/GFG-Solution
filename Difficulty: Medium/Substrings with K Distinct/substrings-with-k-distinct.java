// User function Template for Java
class Solution {
    int countSubstr(String s, int k) {
        return (int)(countAtMostK(s, k) - countAtMostK(s, k - 1));
    }
    
    private long countAtMostK(String s, int k) {
        if (k < 0) return 0;  
        
        HashMap<Character, Integer> freq = new HashMap<>();
        int left = 0;
        long count = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
            
            while (freq.size() > k) {
                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar) - 1);
                if (freq.get(leftChar) == 0) {
                    freq.remove(leftChar);
                }
                left++;
            }
            
            
            count += right - left + 1;
        }
        
        return count;
    }
}