class Solution {
    public int binarySearch(int[] arr, int target){
        int l = 0;
        int r = arr.length-1;
        int ans = arr.length; // default
        while(l<=r){
            int mid = l + (r-l)/2;
            if(arr[mid]>=target){
                ans = mid; // we found the index, arr[mid]>target
                r = mid-1; // go for better ans
            }else{
                l = mid+1;
            }
        }
        return ans;
    }
    public ArrayList<Integer> cntInRange(int[] arr, int[][] queries) {
        Arrays.sort(arr); // for binary search
        
        ArrayList<Integer> result = new ArrayList<>();
        for(int[] query : queries){
            int a = query[0]; // lower bound
            int b = query[1]; // upper bound
            int idx_a = binarySearch(arr, a); // starting index
            int idx_b = binarySearch(arr, b+1); // ending index
            result.add(idx_b - idx_a); // total elements b/w them
        }
        return result; // ans
    }
}