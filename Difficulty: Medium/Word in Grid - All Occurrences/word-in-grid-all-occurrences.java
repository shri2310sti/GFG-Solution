class Solution {
    public ArrayList<ArrayList<Integer>> searchWord(char[][] mat, String word) {
        // code here
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        int[][] dir={{0,1},{1,0},{1,1},{0,-1},{-1,0},{-1,-1},{-1,1},{1,-1}};
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                for(int[] k:dir){
                if(solve(mat,word,i,j,0,k)){
                    ans.add(new ArrayList<>(Arrays.asList(i,j)));
                    break;
                } 
                }
            }
        }
        return ans;
    }
    public boolean solve(char[][] mat,String word, int i, int j, int idx,int[] dir){
        if(i<0 || j<0 || i>=mat.length || j>=mat[0].length) return false;
        if(mat[i][j]!=word.charAt(idx)) return false;
        if(idx==word.length()-1) return true;
        return solve(mat,word,i+dir[0],j+dir[1],idx+1,dir);
    }
};