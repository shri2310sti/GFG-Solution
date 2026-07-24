class Solution {
    int max (int a, int b) {
        return a > b ? a : b;
    }
    
    int longest (int prev, int sum, Node root) {
        if (root == null) return sum;
        
        int next_sum = prev + 1 != root.data ? 0 : sum + 1;
        
        int max_left_right = max(
            longest(root.data, next_sum, root.right), 
            longest(root.data, next_sum, root.left)
        );
        
        return max(sum, max_left_right);
    }
    
    public int longestConsecutive(Node root) {
        int max = longest(root.data, 0, root);
        
        return max == 0 ? -1 : max + 1;
    }
}