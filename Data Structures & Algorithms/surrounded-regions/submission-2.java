class Solution {
    int[] x = {-1, 1, 0, 0};
    int[] y = {0, 0, -1, 1};
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int col = 0; col < n; col++) {
            if (board[0][col] == 'O') {
                dfs(0, col, m, n, board);
            }
            if (board[m - 1][col] == 'O') {
                dfs(m-1, col, m, n, board);
            }
        }
        for (int row = 0; row < m; row++) {
            if (board[row][0] == 'O') {
                dfs(row, 0, m, n, board);
            }
            if (board[row][n - 1] == 'O') {
                dfs(row, n-1, m, n, board);
            }
        }
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if(board[row][col] == 'O'){
                    board[row][col] = 'X';
                }else if(board[row][col] == 'S'){
                    board[row][col] = 'O';
                }
            }
        }   
    }
    public void dfs(int row, int col, int m, int n, char[][] board){
        if(row < 0 || col < 0 || row >= m || col >= n){
            return;
        }
        if(board[row][col] != 'O'){
            return;
        }
        board[row][col] = 'S';
        for(int k =0; k<4;k++){
            int newrow = row + x[k];
            int newcol = col + y[k];
            dfs(newrow, newcol, m, n, board);
        }
    }
}
