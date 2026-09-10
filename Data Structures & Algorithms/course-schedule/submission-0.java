class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        // Create an empty list for every cource
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        // create directed graph
        for (int i = 0; i < prerequisites.length; i++) {
            int cource = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];

            // Prerequisite -> cource
            graph.get(prerequisite).add(cource);
        }
        // 0 - Not Visited
        // 1 - Currently Processing
        // 2 - Already Processing
        int[] state = new int[numCourses];

        //Check every Cource
        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                boolean possible = dfs(i, graph, state);

                if (possible == false) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(int node, List<List<Integer>> graph, int [] state){
        
        if(state[node] == 1){
            return false;
        }

        if(state[node] == 2){
            return true;
        }

        state[node] = 1;

        List<Integer> neighbour = graph.get(node);

        for(int i=0; i<neighbour.size(); i++){
            int nextnode = neighbour.get(i);

            boolean possible = dfs(nextnode, graph, state);
            if(possible == false){
                return false;
            }
        }
        state[node] = 2;
        return true;
    }
}
