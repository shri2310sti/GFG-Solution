


class Solution {
    static boolean canAttend(int[][] arr) {
        // Step 1: Sort meetings by their start time
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        // Step 2: Check for overlapping meetings
        for (int i = 1; i < arr.length; i++) {
            // If the start time of the current meeting is less than the end time of the previous meeting
            if (arr[i][0] < arr[i - 1][1]) {
                return false;
            }
        }

        // If no overlaps are found, return true
        return true;
    }
}
