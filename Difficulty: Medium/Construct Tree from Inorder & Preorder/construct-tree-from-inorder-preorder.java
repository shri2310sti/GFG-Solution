//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            Node root = null;

            // Read inorder array
            String[] inorderStr = (br.readLine()).trim().split(" ");
            int inorder[] = new int[inorderStr.length];
            for (int i = 0; i < inorderStr.length; i++) {
                inorder[i] = Integer.parseInt(inorderStr[i]);
            }

            // Read preorder array
            String[] preorderStr = (br.readLine()).trim().split(" ");
            int preorder[] = new int[preorderStr.length];
            for (int i = 0; i < preorderStr.length; i++) {
                preorder[i] = Integer.parseInt(preorderStr[i]);
            }

            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder);
            postOrder(root);
            System.out.println();
        }
    }

    // Function to print postorder traversal of the tree
    public static void postOrder(Node root) {
        if (root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
}

// } Driver Code Ends


/*
class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}
*/


class Solution {
    static int preIndex = 0;
    static HashMap<Integer, Integer> inorderMap;

    public static Node buildTree(int inorder[], int preorder[]) {
        inorderMap = new HashMap<>();
        preIndex = 0;

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return constructTree(preorder, 0, inorder.length - 1);
    }

    private static Node constructTree(int[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;

        int rootValue = preorder[preIndex++];
        Node root = new Node(rootValue);

        int inIndex = inorderMap.get(rootValue);

        root.left = constructTree(preorder, inStart, inIndex - 1);
        root.right = constructTree(preorder, inIndex + 1, inEnd);

        return root;
    }

    public static void postOrderTraversal(Node root, List<Integer> result) {
        if (root == null) return;
        postOrderTraversal(root.left, result);
        postOrderTraversal(root.right, result);
        result.add(root.data);
    }

    public static List<Integer> getPostOrder(int inorder[], int preorder[]) {
        Node root = buildTree(inorder, preorder);
        List<Integer> postorderList = new ArrayList<>();
        postOrderTraversal(root, postorderList);
        return postorderList;
    }

    
}

