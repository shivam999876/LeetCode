class Solution {
public:
    int timeRequiredToBuy(vector<int>& v, int k) {
        int n=v.size();
        int value=v[k];
        int t=0;
        for(int i=0;i<n;i++) {
            if(i<k) {
                t=t+min(v[i],value);
            } else if(i==k) {
                t=t+value;
            } else {
                if(v[i]<value)
                    t=t+v[i];
                else
                    t=t+value-1;
            }
        }
        return t;
    }
};