//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().maxProfit(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;

        int buy1 = Integer.MAX_VALUE, buy2 = Integer.MAX_VALUE;
        int sell1 = 0, sell2 = 0;

        for (int price : prices) {
            buy1 = Math.min(buy1, price); // Lowest price to buy first stock
            sell1 = Math.max(sell1, price - buy1); // Max profit from first transaction
            buy2 = Math.min(buy2, price - sell1); // Effective lowest price for second buy
            sell2 = Math.max(sell2, price - buy2); // Max profit from second transaction
        }

        return sell2;
    }
}

