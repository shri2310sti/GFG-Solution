class Solution {
    static int evenlyDivides(int n) {
        int temp = n;
        int count = 0;

        while (temp > 0) {
            int digit = temp % 10;

            if (digit != 0 && n % digit == 0) {
                count++;
            }

            temp /= 10;
        }

        return count;
    }
}
