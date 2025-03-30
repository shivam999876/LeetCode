class Solution {
    //comparator function
    static bool comp(vector<int>& d1, vector<int>& d2){
        if(d1[0] == d2[0]){
            if(d1[1] == d2[1]){
                return d1[2] < d2[2];
            }
            return d1[1] < d2[1];
        }
        return d1[0] < d2[0];
    }

    int solve(vector<vector<int>>& cuboid,int prev,int pos, vector<vector<int>>&dp){
        if(pos == cuboid.size()){
            //no more bricks present
            return 0;
        }
        if(dp[prev+1][pos] != -1){
            return dp[prev+1][pos];
        }
        //not take
        int skip = solve(cuboid,prev,pos+1,dp);
        int take = 0;
        //take if it is the first brick or check for bigger brick
        if(prev == -1 || (cuboid[prev][0] <= cuboid[pos][0] && cuboid[prev][1] <= cuboid[pos][1] && cuboid[prev][2] <= cuboid[pos][2])){
            take = cuboid[pos][2] + solve(cuboid,pos,pos+1,dp);
        }
         //return maximum height
        return dp[prev+1][pos] = max(skip,take);
    }
public:
    int maxHeight(vector<vector<int>>& cuboids) {
        //sorting each value
        for(int i = 0; i < cuboids.size(); i++){
            sort(cuboids[i].begin(),cuboids[i].end());
        }
        sort(cuboids.begin(),cuboids.end(),comp);
        vector<vector<int>> dp(cuboids.size() + 1,vector<int>(cuboids.size(),-1));
        return solve(cuboids,-1,0,dp);
    }
};