class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        }
        int [] indegree = new int [numCourses];
        for(int i=0; i<prerequisites.length; i++){
            int cource = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];

            graph.get(prerequisite).add(cource);

            indegree[cource]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i< numCourses; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int [] result = new int [numCourses];
        int index =0;
        while(!q.isEmpty()){
            int current = q.poll();
            result[index] = current;
            index++;

            List<Integer> neighbor = graph.get(current);
            for(int i=0; i<neighbor.size(); i++){
                int nextcource = neighbor.get(i);
                indegree[nextcource]--;

                if(indegree[nextcource] == 0){
                    q.add(nextcource);
                }
            }
        } 
        if(index != numCourses){
            return new int [0];
        }
        return result;
    }
}
