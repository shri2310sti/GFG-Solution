class Solution {
    boolean canFormPalindrome(String s) {
        // code here
        int mask=0;
        for(char c:s.toCharArray()){
            int bit=1<<(c-'a');
            mask^=bit;
        }
        return ((mask & (mask-1))==0);
    }
}