class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<times.length; i++){
            int source = times[i][0];
            int dest = times[i][1];
            int time = times[i][2];

            graph.get(source).add(new int[] {dest, time});
        }
        int [] dist = new int [n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.offer(new int [] {0,k});

        while(!pq.isEmpty()){
            int [] current = pq.poll();
            int currentTime = current[0];
            int currentNode = current[1];

            List<int[]> neighbour = graph.get(currentNode);
            for(int i=0; i<neighbour.size(); i++){
                int nextNode = neighbour.get(i)[0];
                int edgeTime = neighbour.get(i)[1];

                int newTime = edgeTime + currentTime;
                if(newTime < dist[nextNode]){
                    dist[nextNode] = newTime;

                    pq.offer(new int[] {newTime, nextNode});
                }
            }
        }
        int ans =0;
        for(int i=1; i<=n; i++){
            if(dist[i] == Integer.MAX_VALUE){
                return -1;
            }
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}
