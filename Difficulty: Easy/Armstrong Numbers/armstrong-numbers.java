// User function Template for Java
class Solution {
    static boolean armstrongNumber(int n) {
        // code here
        int temp = n;
        int result = 0;
        while(temp > 0){
            int digit = temp % 10;
            result += Math.pow(digit , 3);
            temp /= 10;
        }
        if(result == n) return true;
        return false;
    }
}