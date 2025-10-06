
class Solution {
    public static int[] count_NGE(int arr[], int indices[]) {
        // code here
        int[] ans = new int[indices.length];
        
        for(int i = 0; i < indices.length; i++){
            int count = 0;
            
            for(int j = indices[i] + 1; j<arr.length; j++){
                if(arr[indices[i]] < arr[j] ) count++;
            }
            ans[i] = count;
        }
        return ans;
    }
}
