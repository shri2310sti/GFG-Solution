class Solution {
    int minCost(int[] height) {
        // code here
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int minCost = Integer.MAX_VALUE, n = height.length;
        map.put(0, 0); // Cost to reach index 0 is 0
        
        while(!map.isEmpty()) {
            int idx = map.firstKey();
            int cost1 = map.get(idx), cost2 = map.get(idx);
            
            if(idx == n - 1) minCost = Math.min(minCost, map.get(idx));
            
            if(idx + 1 < n) {
                cost1 += Math.abs(height[idx] - height[idx + 1]);
                if(!map.containsKey(idx + 1) || map.get(idx + 1) > cost1) {
                    map.put(idx + 1, cost1);
                }
            }
            
            if(idx + 2 < n) {
                cost2 += Math.abs(height[idx] - height[idx + 2]);
                if(!map.containsKey(idx + 2) || map.get(idx + 2) > cost2) {
                    map.put(idx + 2, cost2);
                }
            }
            
            map.remove(idx);
        }
        
        return minCost;
    }
}