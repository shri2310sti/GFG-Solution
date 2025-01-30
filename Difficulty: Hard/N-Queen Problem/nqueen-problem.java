//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if (ans.size() == 0)
                System.out.println("-1");
            else {
                ans.sort((list1, list2) -> {
                    int size = Math.min(list1.size(), list2.size());
                    for (int i = 0; i < size; i++) {
                        if (!list1.get(i).equals(list2.get(i))) {
                            return list1.get(i) - list2.get(i);
                        }
                    }
                    return list1.size() - list2.size();
                });

                for (int i = 0; i < ans.size(); i++) {
                    System.out.print("[");
                    for (int j = 0; j < ans.get(i).size(); j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java



// User function Template for Java

class Solution {
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int[] queens = new int[n]; // Index represents column, value represents row
        solveNQueens(n, 0, queens, result);
        return result;
    }
    
    private void solveNQueens(int n, int col, int[] queens, ArrayList<ArrayList<Integer>> result) {
        if (col == n) {
            ArrayList<Integer> solution = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                solution.add(queens[i] + 1); // Convert 0-based index to 1-based for the result
            }
            result.add(solution);
            return;
        }
        
        for (int row = 0; row < n; row++) {
            if (isSafe(queens, col, row)) {
                queens[col] = row; // Place queen at (col, row)
                solveNQueens(n, col + 1, queens, result);
                // Backtrack: remove queen and try the next row
            }
        }
    }
    
    private boolean isSafe(int[] queens, int col, int row) {
        for (int c = 0; c < col; c++) {
            int r = queens[c];
            if (r == row || Math.abs(r - row) == Math.abs(c - col)) {
                return false; // Same row or same diagonal
            }
        }
        return true;
    }
}