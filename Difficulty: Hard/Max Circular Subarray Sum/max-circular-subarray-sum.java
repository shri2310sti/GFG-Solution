class Solution {
    private void print(int[] arr){
        for(int it:arr){
            System.out.print(it+" ");
        }
        System.out.println("");
    }
    private int kadane_algo(int[] arr){
        int n=arr.length;
        int currsum=arr[0];
        int overallsum=arr[0];
        for(int i=1;i<arr.length;i++){
            if(currsum<=0){
                currsum=arr[i];
            }
            else{
                currsum+=arr[i];
            }
            overallsum=Math.max(overallsum,currsum);
        }
        return overallsum;
    }
    private int inv_kadane_algo(int[] arr){
        int n=arr.length;
        int currsum=arr[0];
        int overallsum=arr[0];
        for(int i=1;i<arr.length;i++){
            if(currsum<0){
                currsum+=arr[i];
            }
            else{
                currsum=arr[i];
            }
            overallsum=Math.min(overallsum,currsum);
        }
        return overallsum;
    }
    public int maxCircularSum(int arr[]){
        int n=arr.length;
        int total_sum=0;
        for(int it:arr){
            total_sum+=it;
        }
        int maximum_subarray_sum=kadane_algo(arr);
        int minimum_subarray_sum=inv_kadane_algo(arr);
        if(maximum_subarray_sum>0){
            return Math.max(maximum_subarray_sum,total_sum-minimum_subarray_sum);
        }
        return maximum_subarray_sum;
    }
}