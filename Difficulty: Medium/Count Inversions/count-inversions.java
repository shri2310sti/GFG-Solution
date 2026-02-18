

// User function Template for Java

class Solution {
    // Function to count inversions in the array.
    static int inversionCount(int[] arr) {
        int[] temp = new int[arr.length]; // Temporary array for merge sort
        return mergeSortAndCount(arr, temp, 0, arr.length - 1);
    }

    // Merge Sort function
    static int mergeSortAndCount(int[] arr, int[] temp, int left, int right) {
        int count = 0;
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Count inversions in left half
            count += mergeSortAndCount(arr, temp, left, mid);

            // Count inversions in right half
            count += mergeSortAndCount(arr, temp, mid + 1, right);

            // Count inversions while merging both halves
            count += mergeAndCount(arr, temp, left, mid, right);
        }
        return count;
    }

    // Merge function to count and merge sorted halves
    static int mergeAndCount(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left;     // Starting index for left subarray
        int j = mid + 1;  // Starting index for right subarray
        int k = left;     // Starting index for temp array
        int count = 0;    // Inversion count

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                // Count inversions: all remaining elements in the left subarray
                count += (mid - i + 1);
            }
        }

        // Copy remaining elements from left subarray
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copy remaining elements from right subarray
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // Copy the sorted subarray into the original array
        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

        return count;
    }
}
