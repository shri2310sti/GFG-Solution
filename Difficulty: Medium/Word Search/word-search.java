//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt(); // Number of test cases
        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] mat = new char[n][m];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = sc.next().charAt(0);
                }
            }

            String word = sc.next();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(mat, word);
            if (ans)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    public boolean isWordExist(char[][] mat, String word) {
        int rows = mat.length;
        int cols = mat[0].length;

        // Iterate through each cell in the matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Start DFS if the first character matches
                if (mat[i][j] == word.charAt(0) && dfs(mat, word, 0, i, j, new boolean[rows][cols])) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] mat, String word, int index, int x, int y, boolean[][] visited) {
        // Base Case: If index equals word length, word is found
        if (index == word.length()) {
            return true;
        }

        // Boundary and validity check
        if (x < 0 || y < 0 || x >= mat.length || y >= mat[0].length || visited[x][y] || mat[x][y] != word.charAt(index)) {
            return false;
        }

        // Mark the current cell as visited
        visited[x][y] = true;

        // Explore all 4 possible directions (up, down, left, right)
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };

        for (int d = 0; d < 4; d++) {
            if (dfs(mat, word, index + 1, x + dx[d], y + dy[d], visited)) {
                return true;
            }
        }

        // Backtrack (unmark the visited cell)
        visited[x][y] = false;
        return false;
    }
}
