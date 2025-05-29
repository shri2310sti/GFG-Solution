class Solution {
    // Class to store maximum length and sum
    class Pair {
        int maxLen;
        int maxSum;
        
        Pair(int maxLen, int maxSum) {
            this.maxLen = maxLen;
            this.maxSum = maxSum;
        }
    }
    
    private Pair dfs(Node node, int currLen, int currSum) {
        if (node == null) {
            return new Pair(0, 0);
        }
        
        // Current path length and sum
        currLen++;
        currSum += node.data;
        
        // If leaf node, return current length and sum
        if (node.left == null && node.right == null) {
            return new Pair(currLen, currSum);
        }
        
        // Recurse on left and right children
        Pair left = dfs(node.left, currLen, currSum);
        Pair right = dfs(node.right, currLen, currSum);
        
        // Compare paths
        if (left.maxLen > right.maxLen) {
            return left;
        } else if (right.maxLen > left.maxLen) {
            return right;
        } else {
            // If lengths are equal, return the one with greater sum
            return new Pair(left.maxLen, Math.max(left.maxSum, right.maxSum));
        }
    }
    
    public int sumOfLongRootToLeafPath(Node root) {
        if (root == null) {
            return 0;
        }
        
        // Start DFS with initial length and sum as 0
        Pair result = dfs(root, 0, 0);
        return result.maxSum;
    }
}