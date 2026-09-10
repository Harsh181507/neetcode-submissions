class Solution {
    int [] x = {-1,1,0,0};
    int [] y = {0,0,-1,1};
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for(int row =0;row<m;row++){
            for(int col = 0; col<n;col++){
                if(grid[row][col] == '1'){
                    count++;
                    dfs(grid, row, col, m, n);
                }
            }
        }
        return count;
    }
    public void dfs(char [][] grid, int row, int col, int m, int n){
        if(row < 0 || col < 0 || row >= m || col >= n){
            return;
        }
        if(grid[row][col] == '0'){
            return;
        }
        grid[row][col] = '0';
        for(int k= 0; k<4;k++){
            int newrow = row + x[k];
            int newcol = col + y[k];

            dfs(grid, newrow, newcol, m, n);
        }
    }
}
