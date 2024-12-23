class Solution {
    int count = 0;
    public boolean dfs(char[][] grid, int i,int j,int[][] visited, int previ,int prevj, char c){
        
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]!=c)
            return false;
       
        if(visited[i][j]-visited[previ][prevj]>=3)
            return true;

        if(visited[i][j]!=0)
            return false;
        
        visited[i][j]=count++;
        
        return dfs(grid,i+1,j,visited,i,j,c) || dfs(grid,i-1,j,visited,i,j,c) || dfs(grid,i,j+1,visited,i,j,c) || dfs(grid,i,j-1,visited,i,j,c);
    }
    public boolean containsCycle(char[][] grid) {
        
        int n = grid.length, m = grid[0].length;
        int[][]visited = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==0 && dfs(grid,i,j,visited,i,j,grid[i][j]))
                    return true;
            }
        }
        return false;
    }
}