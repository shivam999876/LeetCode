class Solution {
public:
    string frequencySort(string s) {
        unordered_map<char,int>charFreq;
        for(auto ch : s){
            charFreq[ch]++;
        }
        string ans="";
        while(charFreq.size()>0){
            int maxcount=INT_MIN;
            char ch;
            for(const auto& pair : charFreq){
                if(pair.second > maxcount){
                    maxcount=pair.second;
                    ch=pair.first;
                }
            }
            for(int i=0;i<maxcount;i++){
                    ans+=ch;
                }
            charFreq.erase(ch);
        }
        return ans;
    }
};