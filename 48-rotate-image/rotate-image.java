class Solution {
    public void rotate(int[][] matrix) {
        int m=matrix.length,n=matrix[0].length;
        int[][] temp=new int[m][n];
        for(int i=0;i<m;i++){
            temp[i]=Arrays.copyOf(matrix[i],n);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                matrix[j][n-i-1]=temp[i][j];
            }
        }
    }
}