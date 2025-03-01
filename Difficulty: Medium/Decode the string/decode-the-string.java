//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String s = in.readLine();

            Solution ob = new Solution();
            out.println(ob.decodeString(s));

            out.println("~");
        }
        out.close();
    }
}
// } Driver Code Ends




class Solution {
    static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int num = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0'); // Construct the number
            } else if (c == '[') {
                countStack.push(num); // Push the multiplier
                stringStack.push(currentString); // Push the current string
                currentString = new StringBuilder();
                num = 0;
            } else if (c == ']') {
                int repeatTimes = countStack.pop(); // Get the multiplier
                StringBuilder decodedString = stringStack.pop(); // Get the previous string
                while (repeatTimes-- > 0) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                currentString.append(c); // Append characters normally
            }
        }
        
        return currentString.toString();
    }

    
}
