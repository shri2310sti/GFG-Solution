

// User function Template for Java

// class Node
// {
//     int data;
//     Node left, right;

//     public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }


class Solution {
    public int kthSmallest(Node root, int k) {
        Stack<Node> stack = new Stack<>();

        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            if (stack.isEmpty()) break; 
            
            root = stack.pop(); 
            k--; 
            if (k == 0) return root.data; 
            
            root = root.right;
        }

        return -1; 
    }
}

