class Solution {
    int [] x = {-1,1,0,0};
    int [] y = {0,0,-1,1};
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxArea = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int row = 0; row<m; row++){
            for(int col = 0; col<n; col++){
                if(grid[row][col] == 1){
                    int area =dfs(grid, row, col, m, n);
                    maxArea = Math.max(area, maxArea);
                    
                }
            }
        }
        return maxArea;
    }
    public int dfs(int [][] grid, int row, int col, int m, int n){
        if(row < 0 || col < 0 || row >= m || col >= n){
            return 0;
        }
        if(grid[row][col] == 0){
            return 0;
        }
        int area = 1;
        grid[row][col] = 0;
        for(int k=0;k<4;k++){
            int newrow = row + x[k];
            int newcol = col + y[k];

            area+=dfs(grid, newrow, newcol, m, n);
        }
        return area;
    }
}
