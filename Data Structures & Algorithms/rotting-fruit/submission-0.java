class Solution {
    int [] x = {-1,1,0,0};
    int [] y = {0,0,-1,1};
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int row =0; row < m; row++){
            for(int col=0; col<n; col++){
                if(grid[row][col] == 2){
                    q.add(new int[] {row, col});
                }else if(grid[row][col] == 1){
                    fresh++;
                }
            }
        }
        int minutes=0;
        while(!q.isEmpty() && fresh > 0){
            int size = q.size();
            for(int i=0;i<size;i++){
                int [] current = q.poll();
                int row = current[0];
                int col = current[1];

                for(int k=0;k<4;k++){
                    int newrow = row + x[k];
                    int newcol = col + y[k];

                    if(newrow < 0 || newcol < 0 || newrow >= m || newcol >= n){
                        continue;
                    }
                    if(grid[newrow][newcol] == 1){
                        grid[newrow][newcol] = 2 ;
                        fresh--;

                        q.add(new int[]{newrow, newcol});
                    }
                }
            }
            minutes++;
        }
        if(fresh > 0){
            return -1;
        }
        return minutes;
        
    }
}
