class Solution {
    public static int minCost(int n, int m, int[] x, int[] y) {
       Arrays.sort(x);
       Arrays.sort(y);
       reverse(x);
       reverse(y);
       int i=0;
       int j=0;
       int hor=1;
       int ver=1;
       int totalcost=0;
       while(i<x.length && j<y.length){
           if(x[i]>=y[j]){
               totalcost+=x[i]*hor;
               ver++;
               i++;
           }else{
               totalcost+=y[j]*ver;
               hor++;
               j++;
           }
       }
        while(i<x.length){
            totalcost+=x[i]*hor;
            ver++;
            i++;
        }
        while(j<y.length){
            totalcost+=y[j]*ver;
            hor++;
            j++;
        }
        return totalcost;
    }
    public static void reverse(int[] arr){
        int left =0;
        int right=arr.length-1;
        while(left<right){
            int temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
            
        }
    }
    
}

