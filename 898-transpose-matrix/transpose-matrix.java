class Solution {
    public int[][] transpose(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
        return new int [0][0];
        int m = matrix.length, n = matrix[0].length;
        int [][] result = new int [n][m];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                result [j][i] = matrix[i][j];
            }
        }
        return result;
    }
}