class Solution {
    public int josephus(int n, int k) {
        // Your code here
        ArrayList<Integer> res = new ArrayList<>();
        int index = 0;
        int currIndex = 0;
        for(int i = 1;i<=n;i++)
        {
            res.add(i);
        }
        while(res.size() > 1)
        {
            index = (currIndex + k -1)%res.size();
            currIndex = index;
            res.remove(index);
        }
        return res.get(0);
        
    }
}