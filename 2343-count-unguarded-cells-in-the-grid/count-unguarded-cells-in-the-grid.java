class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] mat = new int[m][n];
        for (int[] guard : guards) {
            mat[guard[0]][guard[1]] = 1; 
        }
        for (int[] wall : walls) {
            mat[wall[0]][wall[1]] = 2; 
        }
        for (int i = 0; i < m; i++) {
            boolean guard = false;
            for (int j = 0; j < n; j++) { 
                if (mat[i][j] == 1) {
                    guard = true;
                } else if (mat[i][j] == 2) {
                    guard = false;
                } else if (guard) {
                    mat[i][j] = 3; 
                }
            }
            guard = false; 
            for (int j = n - 1; j >= 0; j--) { 
                if (mat[i][j] == 1) {
                    guard = true;
                } else if (mat[i][j] == 2) {
                    guard = false;
                } else if (guard) {
                    mat[i][j] = 3;
                }
            }
        } 
        for (int j = 0; j < n; j++) {
            boolean guard = false;
            for (int i = 0; i < m; i++) { 
                if (mat[i][j] == 1) {
                    guard = true;
                } else if (mat[i][j] == 2) {
                    guard = false;
                } else if (guard) {
                    mat[i][j] = 3;
                }
            }
            guard = false; 
            for (int i = m - 1; i >= 0; i--) { 
                if (mat[i][j] == 1) {
                    guard = true;
                } else if (mat[i][j] == 2) {
                    guard = false;
                } else if (guard) {
                    mat[i][j] = 3;
                }
            }
        } 
        int unguarded = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) { 
                    unguarded++;
                }
            }
        }
        return unguarded; 
    }
}