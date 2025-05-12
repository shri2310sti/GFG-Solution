//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        while (t-- > 0) {
            int n = sc.nextInt(); // Number of rooms
            int m = sc.nextInt(); // Number of meetings
            int[][] meetings = new int[m][2];
            for (int i = 0; i < m; i++) {
                meetings[i][0] = sc.nextInt(); // Start time
                meetings[i][1] = sc.nextInt(); // End time
            }
            Solution ob = new Solution();
            System.out.println(ob.mostBooked(n, meetings));
            System.out.println("~");
        }
        sc.close();
    }
}


// } Driver Code Ends

// User function Template for Java

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) freeRooms.add(i);

        // busyRooms stores {endTime, roomNo}
        PriorityQueue<long[]> busyRooms = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) return Long.compare(a[1], b[1]);
            return Long.compare(a[0], b[0]);
        });

        int[] count = new int[n];

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];

            // Free rooms that have become available
            while (!busyRooms.isEmpty() && busyRooms.peek()[0] <= start) {
                freeRooms.offer((int) busyRooms.poll()[1]);
            }

            if (!freeRooms.isEmpty()) {
                int room = freeRooms.poll();
                busyRooms.offer(new long[]{end, room});
                count[room]++;
            } else {
                long[] next = busyRooms.poll(); // earliest available
                long newStart = next[0];
                long duration = end - start;
                long newEnd = newStart + duration;
                busyRooms.offer(new long[]{newEnd, next[1]});
                count[(int) next[1]]++;
            }
        }

        int maxCount = -1, roomNo = -1;
        for (int i = 0; i < n; i++) {
            if (count[i] > maxCount || (count[i] == maxCount && i < roomNo)) {
                maxCount = count[i];
                roomNo = i;
            }
        }

        return roomNo;
    }
}



//{ Driver Code Starts.
// } Driver Code Ends