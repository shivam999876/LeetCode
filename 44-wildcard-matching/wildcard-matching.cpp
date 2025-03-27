class Solution {
public:
    bool isMatch(string t, string p) { // O (n * m)
        int n = t.size();
        int m = p.size();
        vector<vector<bool>> dp(n+1, vector<bool>(m+1, false));
        dp[0][0] = true;
        for(int j=1; j<m+1; j++){// 0th row -> text is ""
            if(p[j-1] == '*'){
                dp[0][j] = dp[0][j-1];
            }else{//'?' or eng char
                dp[0][j] = false;
            }
        }
        //bottom up manner fill Dp
        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(t[i-1] == p[j-1] || p[j-1] == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p[j-1] == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];   
                }else{
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
    }
};