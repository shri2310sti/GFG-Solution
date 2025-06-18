class Solution {
    public ArrayList<ArrayList<String>> palinParts(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        ArrayList<String> current = new ArrayList<>();
        backtrack(s, 0, current, result);
        return result;
    }
    
    // Backtracking function to generate partitions
    private void backtrack(String s, int start, ArrayList<String> current, ArrayList<ArrayList<String>> result) {
        // Base case: if we've processed the entire string, add the current partition
        if (start >= s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        // Try all possible substrings starting from 'start'
        for (int end = start; end < s.length(); end++) {
            // Check if substring s[start..end] is a palindrome
            if (isPalindrome(s, start, end)) {
                // Add the palindrome substring to current partition
                current.add(s.substring(start, end + 1));
                // Recurse for the remaining string
                backtrack(s, end + 1, current, result);
                // Backtrack by removing the last substring
                current.remove(current.size() - 1);
            }
        }
    }
    
    // Helper function to check if s[start..end] is a palindrome
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}