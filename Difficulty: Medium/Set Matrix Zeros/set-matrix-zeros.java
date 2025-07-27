

//Back-end complete function Template for Java
class Solution {
    public void setMatrixZeroes(int[][] mat) {
        int n = mat.length;         // number of rows
        int m = mat[0].length;      // number of columns
        
        boolean rowFirst = false;
        boolean colFirst = false;

        // Check if the first column has any zero
        for (int i = 0; i < n; i++) {
            if (mat[i][0] == 0) {
                colFirst = true;
                break;
            }
        }

        // Check if the first row has any zero
        for (int i = 0; i < m; i++) {
            if (mat[0][i] == 0) {
                rowFirst = true;
                break;
            }
        }

        // Use first row and first column to mark zeros for the rest of the matrix
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (mat[i][j] == 0) {
                    mat[i][0] = 0;  // mark the first column
                    mat[0][j] = 0;  // mark the first row
                }
            }
        }

        // Set the elements to zero based on the marks in the first row and first column
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (mat[i][0] == 0 || mat[0][j] == 0) {
                    mat[i][j] = 0;
                }
            }
        }

        // Set the first row to zero if necessary
        if (rowFirst) {
            for (int i = 0; i < m; i++) {
                mat[0][i] = 0;
            }
        }

        // Set the first column to zero if necessary
        if (colFirst) {
            for (int i = 0; i < n; i++) {
                mat[i][0] = 0;
            }
        }
    }
}