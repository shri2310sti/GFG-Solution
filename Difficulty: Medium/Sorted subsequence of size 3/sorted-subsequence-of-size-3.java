

/*Complete the function below*/


class Solution {
    public List<Integer> find3Numbers(int[] arr) {
        int n = arr.length;
        if (n < 3) {
            return new ArrayList<>(); // Return an empty list if there are fewer than 3 elements
        }

        int[] leftMin = new int[n];
        int[] rightMax = new int[n];

        // Step 1: Create leftMin array
        leftMin[0] = arr[0];
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], arr[i]);
        }

        // Step 2: Create rightMax array
        rightMax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
        }

        // Step 3: Find the subsequence
        for (int j = 1; j < n - 1; j++) {
            if (arr[j] > leftMin[j - 1] && arr[j] < rightMax[j + 1]) {
                return Arrays.asList(leftMin[j - 1], arr[j], rightMax[j + 1]);
            }
        }

        // Step 4: If no such subsequence is found, return an empty list
        return new ArrayList<>();
    }
}
