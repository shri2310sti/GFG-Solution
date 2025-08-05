class Solution {
    public boolean isPalinSent(String s) {
        // code here
        if (s == null || s.length() == 0) {
            return true;
        }
        int length = s.length();
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            char leftChar = Character.toLowerCase(s.charAt(left));
            char rightChar = Character.toLowerCase(s.charAt(right));
            if (((leftChar >= 'a' && leftChar <= 'z') || (leftChar >= '0' && leftChar <= '9'))  && ((rightChar >= 'a' && rightChar <= 'z') || (rightChar >= '0' && rightChar <= '9'))) {
                if (leftChar == rightChar) {
                    
                    left++;
                    right--;
                }
                else {
                    
                    return false;
                }
            }
            else if ((leftChar >= 'a' && leftChar <= 'z') || (leftChar >= '0' && leftChar <= '9')) {
                
                right--;
            }
            else if ((rightChar >= 'a' && rightChar <= 'z') || (rightChar >= '0' && rightChar <= '9')) {
                
                left++;
            }
            else {
                
                left++;
                right--;
            }
        }
        return true;
    }
}