class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1){
            return false;
        }
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<edges.length; i++){
            int node1 = edges[i][0];
            int node2 = edges[i][1];

            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }
        boolean [] visited = new boolean[n];
        boolean noCycle = dfs(0, -1, graph, visited);
        if(noCycle == false){
            return false;
        }
        for(int i=0; i<n; i++){
            if(visited[i] == false){
                return false; 
            }
        }
        return true;
    }
    public boolean dfs(int current, int parent, List<List<Integer>>graph, boolean [] visited){
        if(visited[current]){
            return false;
        }
        visited[current] = true;

        List<Integer> neighbor = graph.get(current);
        for(int i=0; i<neighbor.size(); i++){
            int nextNode = neighbor.get(i);

            if(nextNode == parent){
                continue;
            }

            boolean possible = dfs(nextNode, current, graph, visited);

            if(possible == false){
                return false;
            }
        }
        return true;
    }
}
