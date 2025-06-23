import java.util.*;

class Solution {
    String minSum(int[] arr) {
        Arrays.sort(arr);  // Step 1: Sort digits

        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();

        // Step 2: Distribute digits alternatively
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0)
                num1.append(arr[i]);
            else
                num2.append(arr[i]);
        }

        // Step 3: Add the two numbers as strings
        String sum = addStrings(num1.toString(), num2.toString());

        // Step 4: Remove leading zeros
        return stripLeadingZeros(sum);
    }

    String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();

        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;

        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;

            if (i >= 0) sum += num1.charAt(i--) - '0';
            if (j >= 0) sum += num2.charAt(j--) - '0';

            res.append(sum % 10);
            carry = sum / 10;
        }

        return res.reverse().toString();
    }

    // Helper function to remove leading zeroes
    String stripLeadingZeros(String str) {
        int i = 0;
        while (i < str.length() && str.charAt(i) == '0') i++;
        return (i == str.length()) ? "0" : str.substring(i);
    }
}
