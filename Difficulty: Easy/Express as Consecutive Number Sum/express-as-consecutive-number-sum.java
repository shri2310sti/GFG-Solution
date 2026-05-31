class Solution {
    public boolean isSumOfConsecutive(int n) {
        // code here
        if(n==1) return false;
        while(n > 1){
            if(n%2 !=0){
                return true;
            }
            n=n/2;
        }
        return false;
    }
}

