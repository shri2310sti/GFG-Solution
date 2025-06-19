import java.util.*;

class Solution {
    public static String caseSort(String s) {
        // Convert string to character array
        char[] chars = s.toCharArray();
        List<Character> upper = new ArrayList<>();
        List<Character> lower = new ArrayList<>();

        // Separate characters
        for (char ch : chars) {
            if (Character.isUpperCase(ch)) {
                upper.add(ch);
            } else {
                lower.add(ch);
            }
        }

        // Sort both lists
        Collections.sort(upper);
        Collections.sort(lower);

        // Reconstruct the result
        StringBuilder result = new StringBuilder();
        int i = 0, j = 0;

        for (char ch : chars) {
            if (Character.isUpperCase(ch)) {
                result.append(upper.get(i++));
            } else {
                result.append(lower.get(j++));
            }
        }

        return result.toString();
    }
}
