class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0;
        int end = m*n - 1;
        while(start <= end){
            int guess = start + (end - start)/2;
            int col = guess % n;
            int row = guess / n;

            if(matrix[row][col] == target){
                return true;
            }
            if(matrix[row][col] < target){
                start = guess + 1;
            }else{
                end = guess - 1;
            }
        }
        return false;
    }
}
