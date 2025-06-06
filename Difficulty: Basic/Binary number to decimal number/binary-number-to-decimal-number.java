// User function Template for Java

class Solution {
    public int binaryToDecimal(String b) {
        // Code here
        int n = b.length();
        int result = 0;
        for(int i = 0; i < n; i++){
            
            if(b.charAt(i) == '1') {
                int p = (int)Math.pow(2,n-i-1);
                result += p;
            }
        }
        return result;
    }
}