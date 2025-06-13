class Solution {
    public int kokoEat(int[] arr, int k) {
        int low = 1, high = 0;
        for (int bananas : arr) {
            high = Math.max(high, bananas);
        }
        
        int result = high;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (canEatAll(arr, k, mid)) {
                result = mid; // try to minimize speed
                high = mid - 1;
            } else {
                low = mid + 1; // need higher speed
            }
        }
        
        return result;
    }
    
    private boolean canEatAll(int[] arr, int k, int s) {
        int hours = 0;
        for (int pile : arr) {
            hours += (pile + s - 1) / s; // same as ceil(pile/s)
        }
        return hours <= k;
    }
}
