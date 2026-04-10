class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        int left = 0;
        int right = matrix.length-1;
        while(left < right) {
            for(int i=0; i<matrix.length; i++) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
            }
            left++;
            right--;
        }
    }

    private void transpose(int[][] matrix) {
        int n = matrix.length;
        for(int i=0; i<n; i++) {
            for(int j = 0; j < n; j++) {
                if(j > i) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
    }
}
