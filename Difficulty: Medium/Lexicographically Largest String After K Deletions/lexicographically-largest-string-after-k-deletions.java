class Solution {
    public static String maxSubseq(String s, int k) {
        int n = s.length();
        int keep = n - k;
        StringBuilder stack = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            // Pop smaller characters from the stack if we can still remove them
            while (stack.length() > 0 && k > 0 && stack.charAt(stack.length() - 1) < c) {
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }

            stack.append(c);
        }

        // Return only the first 'keep' characters
        return stack.substring(0, keep);
    }
}
