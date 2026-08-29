class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (a.getKey() != b.getKey()) {
                        return a.getKey() - b.getKey();
                    }
                    return a.getValue().compareTo(b.getValue());
                });
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            int element = entry.getKey();
            int freq = entry.getValue();

            Pair<Integer, Integer> curr = new Pair<>(freq,element);

            if (pq.size() < k) {
                pq.add(curr);
                continue;
            } else if (curr.getKey() > pq.peek().getKey()) {
                pq.poll();
                pq.add(curr);
            }
        }
        int[] res = new int[k];
        int idx = 0;
        while (!pq.isEmpty()) {
            res[idx++] = pq.poll().getValue();
        }
        return res;
    }
}