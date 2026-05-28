/* Structure of binary tree node
class Node{
public:
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class Solution {
    public ArrayList<Integer> verticalSum(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }        
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, Integer> verticalMap = new HashMap<>(); // O(W)
        int [] leftExtreme = new int [1]; //[0]
        int [] rightExtreme = new int [1]; //[0]
        dfs(root, verticalMap, 0, leftExtreme, rightExtreme);// O(N)
        
        // O(W)
        for (int vertical = leftExtreme[0]; vertical <= rightExtreme[0]; vertical++) {
            result.add(verticalMap.get(vertical));
        }
        return result;
    }
    
    
    // O(H)
    private void dfs(Node node, Map<Integer, Integer> verticalMap, int currentVertical, int [] leftExtreme, int [] rightExtreme) {
        if (node == null) {
            return;
        }
        verticalMap.put(currentVertical, verticalMap.getOrDefault(currentVertical, 0) + node.data);
        leftExtreme[0] = Math.min(leftExtreme[0], currentVertical);
        rightExtreme[0] = Math.max(rightExtreme[0], currentVertical);
        dfs(node.left, verticalMap, currentVertical - 1, leftExtreme, rightExtreme);
        dfs(node.right, verticalMap, currentVertical + 1, leftExtreme, rightExtreme);
    }
}