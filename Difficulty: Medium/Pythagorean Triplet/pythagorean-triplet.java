import java.util.HashSet;

class Solution {
    boolean pythagoreanTriplet(int[] arr) {
        int n = arr.length;

        // Step 1: Create a HashSet of squares
        HashSet<Integer> squares = new HashSet<>();
        for (int i = 0; i < n; i++) {
            squares.add(arr[i] * arr[i]);
        }

        // Step 2: Check all pairs (a, b) for a² + b² = c²
        for (int i = 0; i < n; i++) {
            int a2 = arr[i] * arr[i];
            for (int j = i + 1; j < n; j++) {
                int b2 = arr[j] * arr[j];
                if (squares.contains(a2 + b2)) {
                    return true;
                }
            }
        }

        return false;
    }
}
