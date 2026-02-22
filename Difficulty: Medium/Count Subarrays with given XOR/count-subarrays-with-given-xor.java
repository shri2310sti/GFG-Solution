

class Solution {
    public long subarrayXor(int arr[], int k) {
        // Map to store frequency of prefix XORs
        HashMap<Integer, Integer> xorFreq = new HashMap<>();
        int xor = 0; // To store the current prefix XOR
        long count = 0; // To store the count of subarrays

        for (int num : arr) {
            // Calculate the current prefix XOR
            xor ^= num;

            // Check if the current XOR itself is equal to k
            if (xor == k) {
                count++;
            }

            // Check if there exists a prefix XOR such that (xor ^ k) = prefixXor
            int prefixXor = xor ^ k;
            if (xorFreq.containsKey(prefixXor)) {
                count += xorFreq.get(prefixXor);
            }

            // Update the frequency of the current XOR
            xorFreq.put(xor, xorFreq.getOrDefault(xor, 0) + 1);
        }

        return count;
    }
}
