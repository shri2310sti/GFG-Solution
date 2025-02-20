//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            int[] nums = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                nums[i] = Integer.parseInt(parts[i]);
            }
            Solution ob = new Solution();
            ArrayList<Double> ans = ob.getMedian(nums);
            for (double i : ans) {
                System.out.printf("%.1f ", i);
            }
            System.out.println();
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends



class Solution {
    public ArrayList<Double> getMedian(int[] arr) {
        ArrayList<Double> result = new ArrayList<>();
        
        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        
        PriorityQueue<Integer> right = new PriorityQueue<>();
        
        for (int num : arr) {
            if (left.isEmpty() || num <= left.peek()) {
                left.add(num);
            } else {
                right.add(num);
            }
            
            if (left.size() > right.size() + 1) {
                right.add(left.poll());
            } else if (right.size() > left.size()) {
                left.add(right.poll());
            }
            
            if (left.size() > right.size()) {
                result.add((double) left.peek());
            } else {
                result.add((left.peek() + right.peek()) / 2.0);
            }
        }
        
        return result;
    }
}
