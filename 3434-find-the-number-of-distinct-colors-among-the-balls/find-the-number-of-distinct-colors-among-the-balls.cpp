class Solution {
public:
    vector<int> queryResults(int limit, vector<vector<int>>& queries) {
        unordered_map<int, int> ballColorMap;  // Map to store the color of each ball
        unordered_map<int, int> colorCount;    // Map to count the number of balls for each color
        vector<int> result;                   // Result vector to store the answer after each query
        int distinctColorsCount = 0;           // Number of distinct colors

        for (const auto& query : queries) {
            int ball = query[0];
            int newColor = query[1];

            if (ballColorMap.find(ball) != ballColorMap.end()) {
                int oldColor = ballColorMap[ball];
                colorCount[oldColor]--;
                if (colorCount[oldColor] == 0) {
                    distinctColorsCount--;
                }
            }

            ballColorMap[ball] = newColor;
            if (colorCount[newColor] == 0) {
                distinctColorsCount++;
            }
            colorCount[newColor]++;

            result.push_back(distinctColorsCount);
        }

        return result;
    }
};