class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>(
            (a,b)->{
                if(a.getKey() != b.getKey()){
                    return b.getKey() - a.getKey();
                }
                return b.getValue().compareTo(a.getValue());
            }
        );
        for(int i=0;i<points.length;i++){
            int x = points[i][0];
            int y = points[i][1];
            int dist = x*x + y*y;

            Pair<Integer,Integer> curr = new Pair<>(dist,i);

            if(pq.size() < k){
                pq.add(curr);
            }else if(curr.getKey() < pq.peek().getKey()){
                pq.poll();
                pq.add(curr);
            }
        }
        int [][] res = new int [k][2];
        int idx = 0;
        while(!pq.isEmpty()){
            int pointIndex = pq.poll().getValue();
            res[idx][0] = points[pointIndex][0];
            res[idx][1] = points[pointIndex][1];
            idx++;
        }
        return res;

    }
}
