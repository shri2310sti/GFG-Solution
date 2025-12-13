class Solution {
    public void swapDiagonal(int[][] mat) {
        // code here
        for(int i=0; i<mat.length; i++){
            int j = mat[i].length - 1 - i;
            int temp = mat[i][i];
            mat[i][i] = mat[i][j];
            mat[i][j] = temp;
        }
    }
}