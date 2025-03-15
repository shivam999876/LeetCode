class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        int n = grid.size();  // Get the number of rows
        int m = grid[0].size();  // Get the number of columns
        
        // Queue to store the rotten oranges and their time stamp { {row, col}, time }
        queue<pair<pair<int, int>, int>> q;

        // Visited matrix to track which oranges are already processed
        vector<vector<int>> vis(n, vector<int>(m, 0));

        // Step 1: Push all initially rotten oranges into the queue
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 2) {  // Rotten orange found
                    q.push({{i, j}, 0}); // Store position and time (0 initially)
                    vis[i][j] = 2;  // Mark it as visited using 2
                }
            }
        }

        int time = 0;  // Track the time required to rot all oranges

        // Direction arrays for moving up, right, down, left
        int drow[] = {-1, 0, 1, 0};
        int dcol[] = {0, 1, 0, -1};

        // Step 2: Perform BFS traversal to rot fresh oranges
        while(!q.empty()) {
            int r = q.front().first.first;  // Current row
            int c = q.front().first.second; // Current column
            int t = q.front().second;  // Current time
            q.pop();

            time = max(time, t);  // Update the time taken

            // Traverse all 4 possible directions
            for(int i = 0; i < 4; i++) {
                int nrow = r + drow[i];  // New row
                int ncol = c + dcol[i];  // New column

                // Check if the new position is within bounds and contains a fresh orange
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                    q.push({{nrow, ncol}, t + 1});  // Push newly rotten orange with updated time
                    vis[nrow][ncol] = 2;  // Mark it as visited (rotten)
                    grid[nrow][ncol] = 2; // Update grid to indicate it's now rotten
                }
            }
        }

        // Step 3: Check if any fresh oranges are left
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {  // If any fresh orange is left, return -1
                    return -1;
                }
            }
        }

        return time;  // Return the total time taken to rot all oranges
    }
};