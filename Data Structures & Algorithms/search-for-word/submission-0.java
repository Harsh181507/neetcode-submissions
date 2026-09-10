class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for(int i=0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(dfs(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char [][] board, String word, int row, int col, int index){
        if(index == word.length()){
            return true;
        }
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length){
            return false;
        }
        if(board[row][col] != word.charAt(index)){
            return false;
        }
        char temp = board[row][col];
        board[row][col] = '#';
        
        int [] x = {-1,1,0,0};
        int [] y = {0, 0, -1, 1};

        for(int i=0;i<4;i++){
            int newrow = row + x[i];
            int newcol = col + y[i];

            if(dfs(board, word, newrow, newcol, index+1)){
                return true;
            }
        }
        board[row][col] = temp;
        return false;
    }
}
