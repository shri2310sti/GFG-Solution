class Solution {
    public boolean isMaxHeap(int[] arr) {
        // code here
  
        int n = arr.length;
        
        for(int i = 0 ; i < n/2 ; i++){
            int leftChild = 2 * i + 1;
            int rightChild = 2 * i + 2;
            if(leftChild < n && arr[leftChild] > arr[i]){
                return false;
            }
            if(rightChild < n && arr[rightChild] > arr[i]){
                return false;
            }
        }
        return true;
    }
}


