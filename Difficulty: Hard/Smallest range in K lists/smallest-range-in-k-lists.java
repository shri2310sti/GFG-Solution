//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

public class DriverClass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int arr[][] = new int[k][n];
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < n; j++) arr[i][j] = sc.nextInt();
            }
            ArrayList<Integer> range = new Solution().findSmallestRange(arr);
            System.out.println(range.get(0) + " " + range.get(1));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    class Node {
        int data, row, index;
        Node(int data, int row, int index) {
            this.data = data;
            this.row = row;
            this.index = index;
        }
    }

    public ArrayList<Integer> findSmallestRange(int[][] arr) {
        int k = arr.length;
        int n = arr[0].length;

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.data - b.data);
        int max = Integer.MIN_VALUE;
        int start = 0, end = Integer.MAX_VALUE;

        // Initialize the heap with the first element of each list
        for (int i = 0; i < k; i++) {
            pq.add(new Node(arr[i][0], i, 0));
            max = Math.max(max, arr[i][0]);
        }

        while (true) {
            Node temp = pq.poll();
            int min = temp.data;

            // Update range if it's smaller
            if (max - min < end - start) {
                start = min;
                end = max;
            }

            // Move to the next element in the same row
            if (temp.index + 1 < n) {
                int nextVal = arr[temp.row][temp.index + 1];
                pq.add(new Node(nextVal, temp.row, temp.index + 1));
                if (nextVal > max) max = nextVal;
            } else {
                // If we have reached the end of one list, we stop
                break;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(start);
        ans.add(end);
        return ans;
    }
}
