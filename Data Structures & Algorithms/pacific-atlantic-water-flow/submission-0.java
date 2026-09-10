class Solution {
    int[] x = {-1, 1, 0, 0};
    int[] y = {0, 0, -1, 1};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] atlantic = new boolean[m][n];
        boolean[][] pacific = new boolean[m][n];
        for (int col = 0; col < n; col++) {
            dfs(0, col, m, n, heights, pacific);
        }
        for (int row = 0; row < m; row++) {
            dfs(row, 0, m, n, heights, pacific);
        }
        for (int col = 0; col < n; col++) {
            dfs(m - 1, col, m, n, heights, atlantic);
        }
        for (int row = 0; row < m; row++) {
            dfs(row, n - 1, m, n, heights, atlantic);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int row = 0; row<m;row++){
            for(int col=0; col<n;col++){
                if(pacific[row][col] && atlantic[row][col]){
                    ans.add(Arrays.asList(row, col));
                }
            }
        }
        return ans;
    }
    public void dfs(int row, int col, int m, int n, int [][] heights, boolean [][] visited){
        if(row < 0 || col < 0 || row >= m || col >= n){
            return;
        }
        if(visited[row][col]){
            return;
        }
        visited[row][col] = true;
        for(int k=0;k<4;k++){
            int newrow = row + x[k];
            int newcol = col + y[k];

            if(newrow < 0 || newcol < 0 || newrow >= m || newcol >= n){
                continue;
            }
            if(heights[newrow][newcol] >= heights[row][col]){
                dfs(newrow, newcol, m, n, heights, visited);
            }
        }
    }
}
