class Solution {
public:
    int longestPalindromeSubseq(string s) {
        int n =  s.size();
        string s1 = s;
        reverse(s.begin(),s.end());
        vector<vector<int>>v(n+1,vector<int>(n+1,-1));
        for(int i=0;i<n+1;i++){
            v[i][0] = 0;
        }
        for(int i=0;i<n+1;i++){
            v[0][i] = 0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s[i-1] == s1[j-1]){
                    v[i][j] = 1+ v[i-1][j-1];
                }else{
                    int case1 = v[i-1][j];
                    int case2 = v[i][j-1];
                    v[i][j] = max(case1,case2);
                }
            }
        }
        return v[n][n];
    }
};