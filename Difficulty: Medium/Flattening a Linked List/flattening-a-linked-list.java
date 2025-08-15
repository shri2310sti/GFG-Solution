class Solution {
    // Function to flatten a linked list
    Node flatten(Node root) {
        // code here
        if(root == null || root.next == null) return root;
        
        Node mergeHead = flatten(root.next);
        
        return mergeTwoLists(root, mergeHead);
    }
    Node mergeTwoLists(Node list1, Node list2){
        Node dummy = new Node(-1);
        Node res = dummy;
        
        while(list1 != null && list2 != null){
            if(list1.data < list2.data){
                res.bottom = list1;
                res = list1;
                list1 = list1.bottom;
            }else {
                res.bottom = list2;
                res = list2;
                list2 = list2.bottom;
            }
            res.next = null;
        }
        if(list1 != null){
            res.bottom = list1;
        }else {
            res.bottom = list2;
        }
        return dummy.bottom;
    }
}