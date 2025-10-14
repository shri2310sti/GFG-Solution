/*
class Node {
    int data;
    Node left, right;
    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    int sum=0;
    public int nodeSum(Node root, int l, int r) {
        dfs(root,l,r);
        return sum;
    }
    void dfs(Node root,int l,int r)
    {
        if(root==null)
        return;
        if(root.data>=l && root.data<=r)
        sum+=root.data;
        dfs(root.left,l,r);
        dfs(root.right,l,r);
    }


}
