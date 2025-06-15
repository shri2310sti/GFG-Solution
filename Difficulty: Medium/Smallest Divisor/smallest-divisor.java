class Solution {
    int smallestDivisor(int[] arr, int k) {
        int left = 1;
        int right = 0;
        for (int num : arr) {
            right = Math.max(right, num); // max element in array
        }
        
        int result = right; // upper bound

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int sum = computeSum(arr, mid);

            if (sum <= k) {
                result = mid; // valid answer, try smaller
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    int computeSum(int[] arr, int divisor) {
        int sum = 0;
        for (int num : arr) {
            sum += (num + divisor - 1) / divisor; // ceil(num / divisor)
        }
        return sum;
    }
}
