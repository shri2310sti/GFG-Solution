class Solution {
    ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> result = new ArrayList<>();
        int m = pat.length();
        int n = txt.length();
        
        // Step 1: Build LPS (Longest Prefix Suffix) array for pattern
        int[] lps = new int[m];
        computeLPSArray(pat, m, lps);
        
        // Step 2: Use LPS to search pattern in text
        int i = 0; // index for txt
        int j = 0; // index for pat
        while (i < n) {
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }

            if (j == m) {
                result.add(i - j + 1); // Convert to 1-based index
                j = lps[j - 1];
            } else if (i < n && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i++;
            }
        }

        return result;
    }

    // Helper method to build the LPS array
    void computeLPSArray(String pat, int m, int[] lps) {
        int len = 0;
        lps[0] = 0; // LPS[0] is always 0
        int i = 1;

        while (i < m) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
}
