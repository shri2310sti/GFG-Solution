class Solution {
    static int[] farr;
    public int query(int idx){
        int ans = 0;
        while(idx > 0){
            ans += farr[idx];
            idx -= (idx & (-idx));
        }
        return ans;
    }
    public void update(int idx,int val){
        while(idx < farr.length){
            farr[idx] += val;
            idx += (idx & (-idx));
        }
    }
    public int countSubstring(String s) {
        int n = s.length();
        int val = (int)(1e5);
        farr = new int[2*(int)(1e5)];
        int sum = 0;
        int ans = 0;
        update(val,1);
        for(int i =0;i<n;i++){
            char ch = s.charAt(i);
            if(ch - '0' == 0){
                sum -= 1;
            }else{
                sum += 1;
            }
            int p = sum + val;
            ans += query(p - 1);
            update(p,1);
        }
       return ans;
    }
}