class Solution {
    public int maxCharGap(String s) {
        // code here
        int maxGap=-1;
        int[] first=new int[26];
        Arrays.fill(first,-1);
        for(int i=0;i<s.length();i++){
            int idx=s.charAt(i)-'a';
            if(first[idx]==-1) first[idx]=i;
            else{
                int currGap=i-first[idx]-1;
                maxGap=Math.max(maxGap,currGap);
            }
        }
        return maxGap;
    }
};