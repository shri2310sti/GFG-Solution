class Solution {
    public boolean isDeadEnd(Node root) {
        return checkDeadEnd(root, 1, Integer.MAX_VALUE);
    }

    private boolean checkDeadEnd(Node node, int min, int max) {
        if (node == null) return false;

        // Dead end condition: No room to insert
        if (min == max) return true;

        // Check left and right subtrees
        return checkDeadEnd(node.left, min, node.data - 1) ||
               checkDeadEnd(node.right, node.data + 1, max);
    }
}
