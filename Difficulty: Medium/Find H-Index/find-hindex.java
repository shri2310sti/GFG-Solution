class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] count = new int[n + 1]; // Count array to store number of papers with citations
        
        // Count the number of citations for each paper
        for (int c : citations) {
            if (c >= n) {
                count[n]++;
            } else {
                count[c]++;
            }
        }
        
        // Calculate the H-Index
        int hIndex = 0;
        for (int i = n; i >= 0; i--) {
            hIndex += count[i]; // Add papers with at least i citations
            if (hIndex >= i) {
                return i; // Found the largest H satisfying the condition
            }
        }
        
        return 0;
    }
}