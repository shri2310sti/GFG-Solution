


import java.util.Arrays;

class Solution {
    // helper: check if we can make median >= target with at most k increments
    private boolean isPossible(int[] arr, long target, long k) {
        int n = arr.length;

        if (n % 2 == 1) {
            // for odd n, raise elements from middle to end up to target
            for (int i = n / 2; i < n; ++i) {
                if (arr[i] < target) {
                    k -= (target - arr[i]);
                    if (k < 0) return false;
                }
            }
        } else {
            // for even n, handle the two middle elements first (mirror of your C++ logic)
            if (arr[n / 2] <= target) {
                k -= (target - arr[n / 2]);
                if (k < 0) return false;
                k -= (target - arr[n / 2 - 1]);
                if (k < 0) return false;
            } else {
                // same expression as C++: k -= (2*target - (arr[mid] + arr[mid-1]))
                k -= (2L * target - (arr[n / 2] + (long)arr[n / 2 - 1]));
                if (k < 0) return false;
            }
            for (int i = n / 2 + 1; i < n; ++i) {
                if (arr[i] < target) {
                    k -= (target - arr[i]);
                    if (k < 0) return false;
                }
            }
        }

        return k >= 0;
    }

    public int maximizeMedian(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);

        // initial median as in your C++ code (integer division for even n)
        int iniMedian = arr[n / 2];
        if (n % 2 == 0) {
            iniMedian = (arr[n / 2] + arr[n / 2 - 1]) / 2;
        }

        long low = iniMedian;
        long high = iniMedian + (long) k; // possible upper bound
        int bestMedian = iniMedian;

        while (low <= high) {
            long mid = (low + high) / 2;
            if (isPossible(arr, mid, k)) {
                bestMedian = (int) mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return bestMedian;
    }

}