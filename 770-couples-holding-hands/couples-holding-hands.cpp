class Solution {
public:
    int minSwapsCouples(vector<int>& row) {
        int n = row.size();
        unordered_map<int, int> idx;

        for(int i=0; i<n; i++) idx[row[i]] = i;

        int swaps = 0;
        for(int i=0; i<n; i+=2) {
            int per1 = row[i];
            int per2 = row[i+1];
            int part1 = per1 ^ 1;

            if(per2 != part1) {
                swaps++;
                int partnerPos = idx[part1];
                row[i+1] = row[partnerPos];
                row[partnerPos] = per2;

                idx[part1] = i+1;
                idx[per2] = partnerPos;
            }
        }
        return swaps;
    }
};