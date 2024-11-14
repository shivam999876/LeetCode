class Solution {
public:
    bool carPooling(vector<vector<int>>& trips, int capacity) {
        int m[1001] = {};
    for (auto a : trips)
    {
        m[a[1]] += a[0];
        m[a[2]] -= a[0];
    }
    for (int i = 0; capacity >= 0 && i < 1001; i++)
    {
        capacity -= m[i];
    }
    return capacity >= 0;
    }
};