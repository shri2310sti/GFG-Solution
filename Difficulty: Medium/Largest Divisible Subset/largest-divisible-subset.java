import java.util.*;

class Solution {
    public ArrayList<Integer> largestSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums); // Sort ascending

        List<List<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < n; i++) dp.add(new ArrayList<>());

        List<Integer> maxSubset = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> best = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (dp.get(j).size() > best.size() ||
                        (dp.get(j).size() == best.size() && isLexGreater(dp.get(j), best))) {
                        best = dp.get(j);
                    }
                }
            }
            dp.get(i).addAll(best);
            dp.get(i).add(nums[i]);

            if (dp.get(i).size() > maxSubset.size() ||
                (dp.get(i).size() == maxSubset.size() && isLexGreater(dp.get(i), maxSubset))) {
                maxSubset = dp.get(i);
            }
        }

        return new ArrayList<>(maxSubset);
    }

    private boolean isLexGreater(List<Integer> a, List<Integer> b) {
        int n = Math.min(a.size(), b.size());
        for (int i = 0; i < n; i++) {
            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) > b.get(i);
            }
        }
        return a.size() > b.size();
    }
}
