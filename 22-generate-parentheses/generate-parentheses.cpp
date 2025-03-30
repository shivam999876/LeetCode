class Solution {
public:
    vector<string> generateParenthesis(int n) {
        vector<string> out;
        int l=0,r=0;
        f(out, "",l,r,n);
        return out;
    }
    void f(vector<string>&out, string s,int l, int r,int n){
        if(l+r==n*2) out.push_back(s);
        else{
            if(l<n) f(out,s+"(",l+1,r,n);
            if(r<l) f(out,s+")",l,r+1,n);
        }
        return;
    }

};