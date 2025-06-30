class Solution {
    public int maxMinHeight(int[] arr, int k, int w) {
        int n = arr.length;
        int low = Arrays.stream(arr).min().getAsInt();
        int high = low + k;

        int result = low;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(arr, mid, k, w)) {
                result = mid; // try for a higher minimum
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    private boolean isPossible(int[] arr, int target, int k, int w) {
        int n = arr.length;
        long[] waterAdd = new long[n + 1];
        long added = 0;
        long ops = 0;

        for (int i = 0; i < n; i++) {
            added += waterAdd[i];

            long current = arr[i] + added;
            if (current < target) {
                long diff = target - current;
                ops += diff;
                if (ops > k) return false;

                added += diff;
                if (i + w < n)
                    waterAdd[i + w] -= diff;
            }
        }

        return true;
    }
}
