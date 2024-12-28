class Solution {
public:
    string getSmallestString(int n, int k) {
        string ans;
    while (n > 0)
    {
        int ch = max(1, k - (n - 1) * 26);
        ans.push_back('a' + ch - 1);
        k -= ch;
        n--;
    }
    return ans;
    }
};