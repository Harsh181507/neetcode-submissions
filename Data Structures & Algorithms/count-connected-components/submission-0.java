class Solution {
    public int countComponents(int n, int[][] edges) {
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

        boolean [] visited = new boolean [n];

        int count = 0;
        for(int i=0; i<n;i++){
            if(visited[i] == false){
                count++;
                dfs(i, graph, visited);
            }
        }
        return count;
    }
    public void dfs(int node, List<List<Integer>> graph, boolean [] visited){
        
        visited[node] = true;
        List<Integer> neighbor = graph.get(node);
        for(int i=0; i<neighbor.size(); i++){
            int nextNode = neighbor.get(i);

            if(visited[nextNode] == false){
                dfs(nextNode, graph, visited);
            }
        }
    }
}
