class Solution {
    List<Integer> makeBeautiful(int[] arr) {
        // code here
        int n = arr.length;
        int i = 0;
        List<Integer> ans = new ArrayList<>();
        
        while(i < n){
            
            if(!ans.isEmpty() && ((ans.get(ans.size() - 1) < 0 && arr[i] >= 0)
                                || (ans.get(ans.size() - 1) >= 0 && arr[i] < 0))){
                ans.remove(ans.size() - 1);
            }else{
                ans.add(arr[i]);
            }
            i++;
        }
        
        return ans;
    }
}

