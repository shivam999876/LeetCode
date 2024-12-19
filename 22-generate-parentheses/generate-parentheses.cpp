class Solution {
public:
    void helper(vector<string> &ans, int openCount, int closeCount, int n, string str)
    { // Base Case
        if (openCount == n and closeCount == n)
        {
            ans.push_back(str);
            return;
        }
        else
        {
            if (openCount > closeCount)
            {
                helper(ans, openCount, closeCount + 1, n, str + ')');
            }
            if (openCount < n)
            {
                helper(ans, openCount + 1, closeCount, n, str + '(');
            }
        }
    }
    vector<string> generateParenthesis(int n) {
        vector<string> ans;
        helper(ans, 0, 0, n, "");
        return ans;
    }
};