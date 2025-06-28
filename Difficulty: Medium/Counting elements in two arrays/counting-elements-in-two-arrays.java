import java.util.*;

class Solution {
    public static ArrayList<Integer> countLessEq(int a[], int b[]) {
        ArrayList<Integer> result = new ArrayList<>();
        
        Arrays.sort(b);
        
        for (int num : a) {
            int count = upperBound(b, num);
            result.add(count);
        }
        
        return result;
    }

    private static int upperBound(int[] arr, int key) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= key) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;  // number of elements ≤ key
    }
}
