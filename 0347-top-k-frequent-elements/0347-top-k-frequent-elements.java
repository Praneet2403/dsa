class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer , Integer> mp = new HashMap<>();

        for(int i : nums) {
            mp.put(i , mp.getOrDefault(i , 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> mp.get(b) - mp.get(a));

        pq.addAll(mp.keySet());

        int[] ans = new int[k];

        for(int i = 0; i< k; i++) {
            ans[i] = pq.poll();
        }
        return ans;
    }
}