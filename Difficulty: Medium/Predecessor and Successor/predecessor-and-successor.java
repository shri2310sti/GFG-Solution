

/* BST Node
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
} */

class Solution {
    Node pre = null, suc = null;

    public ArrayList<Node> findPreSuc(Node root, int key) {
        findPreSucHelper(root, key);
        ArrayList<Node> res = new ArrayList<>();
        res.add(pre);
        res.add(suc);
        return res;
    }

    private void findPreSucHelper(Node root, int key) {
        if (root == null) return;

        if (root.data == key) {
            // Find predecessor
            if (root.left != null) {
                Node temp = root.left;
                while (temp.right != null) temp = temp.right;
                pre = temp;
            }
            // Find successor
            if (root.right != null) {
                Node temp = root.right;
                while (temp.left != null) temp = temp.left;
                suc = temp;
            }
        }
        else if (root.data > key) {
            suc = root;
            findPreSucHelper(root.left, key);
        }
        else {
            pre = root;
            findPreSucHelper(root.right, key);
        }
    }
}
