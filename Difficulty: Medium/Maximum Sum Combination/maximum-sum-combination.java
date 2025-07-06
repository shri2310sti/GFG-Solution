import java.util.*;

class Solution {
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        Arrays.sort(a);
        Arrays.sort(b);
        int n = a.length;
        ArrayList<Integer> result = new ArrayList<>();

        // Max Heap with custom comparator to sort in decreasing order of sum
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((p1, p2) -> p2.sum - p1.sum);

        // Set to avoid pushing same pair multiple times
        Set<String> visited = new HashSet<>();

        // Start from the largest elements
        int i = n - 1, j = n - 1;
        maxHeap.add(new Pair(a[i] + b[j], i, j));
        visited.add(i + "," + j);

        while (k-- > 0 && !maxHeap.isEmpty()) {
            Pair current = maxHeap.poll();
            result.add(current.sum);

            i = current.i;
            j = current.j;

            // Move in a[]: (i - 1, j)
            if (i - 1 >= 0 && !visited.contains((i - 1) + "," + j)) {
                maxHeap.add(new Pair(a[i - 1] + b[j], i - 1, j));
                visited.add((i - 1) + "," + j);
            }

            // Move in b[]: (i, j - 1)
            if (j - 1 >= 0 && !visited.contains(i + "," + (j - 1))) {
                maxHeap.add(new Pair(a[i] + b[j - 1], i, j - 1));
                visited.add(i + "," + (j - 1));
            }
        }

        return result;
    }

    class Pair {
        int sum;
        int i;
        int j;

        Pair(int sum, int i, int j) {
            this.sum = sum;
            this.i = i;
            this.j = j;
        }
    }
}
