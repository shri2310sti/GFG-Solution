class Solution {

   public static boolean isPossible(int[] arr, int k) {
        // Code here
        
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> end = new HashMap<>();

        for (int num : arr) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for (int num : arr) {
            if (count.get(num) == 0) continue; 

            count.put(num, count.get(num) - 1);

            if (end.getOrDefault(num - 1, 0) > 0) {
                end.put(num - 1, end.get(num - 1) - 1);
                end.put(num, end.getOrDefault(num, 0) + 1);
            }
            
            else {
                boolean canForm = true;
                for (int j = 1; j < k; j++) {
                    if (count.getOrDefault(num + j, 0) <= 0) {
                        canForm = false;
                        break;
                    }
                }
                if (!canForm) return false;

                for (int j = 1; j < k; j++) {
                    count.put(num + j, count.get(num + j) - 1);
                }

                end.put(num + k - 1, end.getOrDefault(num + k - 1, 0) + 1);
            }
        }

        return true;
    }
}