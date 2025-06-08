import java.math.BigInteger;

class Solution {
    public boolean isSumString(String s) {
        int n = s.length();
        
        // Try all possible first and second splits
        for (int i = 1; i <= n / 2; i++) {
            for (int j = 1; i + j < n; j++) {
                String s1 = s.substring(0, i);
                String s2 = s.substring(i, i + j);
                
                // Skip numbers with leading zeroes
                if ((s1.length() > 1 && s1.startsWith("0")) || (s2.length() > 1 && s2.startsWith("0")))
                    continue;
                
                if (check(s1, s2, s.substring(i + j)))
                    return true;
            }
        }
        return false;
    }

    private boolean check(String s1, String s2, String remaining) {
        BigInteger num1 = new BigInteger(s1);
        BigInteger num2 = new BigInteger(s2);
        BigInteger sum = num1.add(num2);
        String sumStr = sum.toString();

        if (!remaining.startsWith(sumStr))
            return false;

        if (remaining.equals(sumStr))
            return true;

        // Continue recursion with s2, sumStr, and the remaining string
        return check(s2, sumStr, remaining.substring(sumStr.length()));
    }
}
