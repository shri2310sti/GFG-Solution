class Solution {
    public ArrayList<ArrayList<Integer>> kClosest(int[][] points, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        
        for (int[] ref : points) {
            int cal = (int)Math.pow(ref[0],2) + (int)Math.pow(ref[1],2);

            if (pq.size() < k) {
                pq.offer(new int[]{cal, ref[0], ref[1]});
            } else if (pq.peek()[0] > cal) {
                pq.poll();
                pq.offer(new int[]{cal, ref[0], ref[1]});
            }
        }
        
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            res.add(new ArrayList<>(Arrays.asList(top[1], top[2])));
        }
        
        return res;
    }
}