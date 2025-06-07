class Solution {
    public static int[] lcmAndGcd(int a, int b) {
        // Compute GCD using Euclidean algorithm
        int gcd = gcd(a, b);
        
        // Compute LCM using the formula: LCM = (a * b) / GCD
        // To avoid overflow, use: LCM = (a / GCD) * b
        long lcm = ((long) a / gcd) * b;
        
        // Return array [LCM, GCD]
        return new int[]{(int) lcm, gcd};
    }
    
    // Helper function to compute GCD using Euclidean algorithm
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}