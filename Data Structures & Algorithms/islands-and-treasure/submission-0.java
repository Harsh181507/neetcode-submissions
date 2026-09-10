class Solution {
    int [] x = {-1,1,0,0};
    int [] y = {0,0,-1,1};
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int INF = 2147483647;
        Queue<int[]> q = new LinkedList<>();
        for(int row = 0;row<m;row++){
            for(int col=0; col<n; col++){
                if(grid[row][col] == 0){
                    q.add(new int [] {row, col});
                }
            }
        }
        while(!q.isEmpty()){
            int [] current = q.poll();
            int row = current[0];
            int col = current[1];

            for(int k=0;k<4;k++){
                int newrow = row + x[k];
                int newcol = col + y[k];

                if(newrow < 0 || newcol < 0 || newrow >= m || newcol >= n){
                    continue;
                }
                if(grid[newrow][newcol] != INF){
                    continue;
                }
                grid[newrow][newcol] = grid[row][col] + 1;
                q.add(new int [] {newrow, newcol});

            }
        }

    }
}
