class Solution {
public:
    int balancedStringSplit(string s) {
        int ans = 0, countR = 0, countL = 0;
    for (char c : s)
    {
        if (c == 'R')
            countR++;
        else
            countL++;
        if (countR == countL)
        {
            ans++;
            countR = countL = 0;
        }
    }
    return ans;
    }
};