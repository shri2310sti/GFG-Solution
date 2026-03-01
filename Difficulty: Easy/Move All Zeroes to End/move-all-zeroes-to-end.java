

// User function Template for Java

class Solution {
    void pushZerosToEnd(int[] arr) {
        int n = arr.length;
        int nonZeroIndex = 0;

        // Move all non-zero elements to the front
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[nonZeroIndex] = arr[i];
                nonZeroIndex++;
            }
        }

        // Fill the remaining positions with zeros
        for (int i = nonZeroIndex; i < n; i++) {
            arr[i] = 0;
        }
    }
}
