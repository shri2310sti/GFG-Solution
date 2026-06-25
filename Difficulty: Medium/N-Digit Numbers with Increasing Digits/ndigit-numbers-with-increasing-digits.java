class Solution {
    public static ArrayList<Integer> increasingNumbers(int n) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        if (n == 0) return res;
        recur(n, 0, res);
        if (n == 1) res.add(0, 0);
        return res;
    }
    
    private static void recur(int n, int curr, ArrayList<Integer> res) {
        if (n == 0) {
            res.add(curr);
            return;
        }
        
        int lastDigit = curr % 10;
        
        for (int i = lastDigit + 1; i < 10; i++) {
            curr = curr * 10 + i;
            recur(n - 1, curr, res);
            curr = curr / 10;
        }
    }
}

