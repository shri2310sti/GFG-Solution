class Solution {
    int countFreq(int[] arr, int target) {
        // code here
        int low = 0, high = arr.length - 1;
        int[] ans = {-1, -1};

        while(low <= high){
            int mid = (low + high) / 2;

            if(arr[mid] == target){
                ans[0] = mid;
                ans[1] = mid;
                // expanding left side
                while(ans[0] > 0 && arr[ans[0] - 1] == target){
                    ans[0] --;
                }
                // expanding right side
                while(ans[1] < arr.length - 1 && arr[ans[1] + 1] == target){
                    ans[1] ++;
                }
                return (ans[1] - ans[0] + 1);
            }
            else if(arr[mid] < target) low = mid + 1;
            else high = mid -1;

        }
        return 0;
    }
}
