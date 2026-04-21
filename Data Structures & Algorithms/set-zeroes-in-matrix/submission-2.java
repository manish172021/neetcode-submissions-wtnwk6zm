class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        boolean firstRow0 = false, firstCol0 = false;
        for(int row=0; row<rows; row++) {
            for(int col=0; col<cols; col++) {
                if(matrix[row][col] == 0) {
                    if(row == 0) firstRow0 = true;
                    if(col == 0) firstCol0 = true;
                    matrix[0][col] = 0;
                    matrix[row][0] = 0;
                }
            }
        }
        for(int row=1; row<rows; row++) {
            for(int col=1; col<cols; col++) {
                if(matrix[row][0] == 0 || matrix[0][col] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }
        if(firstRow0) {
            for(int col=0; col<cols; col++) {
                matrix[0][col] = 0;
            }
        }
        if(firstCol0) {
            for(int row=0; row<rows; row++) {
                matrix[row][0] = 0;
            }
        }
    }
}
