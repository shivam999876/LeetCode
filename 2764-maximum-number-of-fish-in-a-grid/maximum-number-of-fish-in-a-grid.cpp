class Solution {
public:
    int findMaxFish(vector<vector<int>>& grid) {
         int m = grid.size();
        int n = grid[0].size();
        int maxFish = 0;
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        
        // DFS to explore all possible starting cells
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    int fish = dfs(grid, visited, i, j);
                    maxFish = max(maxFish, fish);
                }
            }
        }
        
        return maxFish;
    }
    
    int dfs(vector<vector<int>>& grid, vector<vector<bool>>& visited, int i, int j) {
        if (i < 0 || i >= grid.size() || j < 0 || j >= grid[0].size() || visited[i][j] || grid[i][j] == 0) {
            return 0;
        }
        
        visited[i][j] = true;
        int fish = grid[i][j];
        grid[i][j] = 0; // mark as visited
        fish += dfs(grid, visited, i+1, j); // down
        fish += dfs(grid, visited, i-1, j); // up
        fish += dfs(grid, visited, i, j+1); // right
        fish += dfs(grid, visited, i, j-1); // left
        
        return fish;
    }
};