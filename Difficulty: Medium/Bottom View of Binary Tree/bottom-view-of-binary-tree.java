

//User function Template for Java


class Solution
{
    //Function to return a list containing the bottom view of the given tree.
     public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        // TreeMap to store horizontal distance and last node at that distance
        TreeMap<Integer, Integer> map = new TreeMap<>();

        // Queue for level order traversal
        Queue<AbstractMap.SimpleEntry<Node, Integer>> queue = new LinkedList<>();
        queue.add(new AbstractMap.SimpleEntry<>(root, 0));

        while (!queue.isEmpty()) {
            AbstractMap.SimpleEntry<Node, Integer> entry = queue.poll();
            Node node = entry.getKey();
            int distance = entry.getValue();

            // Update the map with the current node at its distance
            map.put(distance, node.data);

            // Enqueue left child with distance - 1
            if (node.left != null) {
                queue.add(new AbstractMap.SimpleEntry<>(node.left, distance - 1));
            }

            // Enqueue right child with distance + 1
            if (node.right != null) {
                queue.add(new AbstractMap.SimpleEntry<>(node.right, distance + 1));
            }
        }

        // Extracting values from TreeMap
        for (int value : map.values()) {
            result.add(value);
        }

        return result;
    }
}