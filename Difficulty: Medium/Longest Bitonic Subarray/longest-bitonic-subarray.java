class Solution {
    int bitonic(int[] arr) {
        // code here
        int n = arr.length;
        int arr1[] = new int[n];
        int arr2[] = new int[n];
        arr1[0] = 1;
        arr2[n - 1] = 1;
        for(int i = 1; i <= n - 1; i++){
            if(arr[i-1] <= arr[i]){
                arr1[i] = arr1[i-1] + 1;
            }else{
                arr1[i] = 1;
            }
        }
        for(int i = n - 2; i >= 0; i--){
            if(arr[i+1] <= arr[i]){
                arr2[i] = arr2[i+1] + 1;
            }else{
                arr2[i] = 1;
            }
        }
        int ans = 0;
        for(int i = 0; i <= n - 1; i++){
            ans = Math.max(ans ,arr1[i]+arr2[i]-1);
        }
        return ans;
    }
}
