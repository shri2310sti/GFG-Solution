import java.util.HashSet;

class Solution {
    int countPairs(int[][] mat1, int[][] mat2, int x) {
        int n = mat1.length;
        int count = 0;

        // Store all elements of mat2 in a HashSet
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                set.add(mat2[i][j]);
            }
        }

        // Traverse mat1 and look for (x - mat1[i][j]) in set
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int target = x - mat1[i][j];
                if (set.contains(target)) {
                    count++;
                }
            }
        }

        return count;
    }
}
