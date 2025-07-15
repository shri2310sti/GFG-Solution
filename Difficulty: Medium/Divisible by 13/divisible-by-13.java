class Solution {
    public boolean divby13(String s) {
        // code here
        long num = 0;
        for(int i = 0; i < s.length(); i++){
            int digit = s.charAt(i) - '0';
            num = (num * 10 + digit) % 13;
        }
        return (num == 0);
    }
}