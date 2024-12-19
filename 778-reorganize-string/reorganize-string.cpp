class Solution {
public:
    string reorganizeString(string s) {
        int n = s.size();
        int charCounts[26] = {};
        for (int i = 0; i < n; i++)
        {
            charCounts[s[i] - 'a']++;
        }
        // max heap with freq, char
        priority_queue<pair<int, char>> pq;
        for (int i = 0; i < 26; i++)
        {
            if (charCounts[i] > 0)
            {
                pq.push({charCounts[i], 'a' + i});
            }
        }
        // String build
        string ans = "";
        pair<int, char> block = pq.top();
        pq.pop();
        ans += block.second;
        block.first--;
        while(!pq.empty()){
            pair<int, char>next = pq.top();
            pq.pop();
            ans += next.second;
            next.first--;
        if (block.first > 0)
        {
            pq.push(block);
        }
        block = next;
    }
    if (block.first > 0)
    {
        return "";
    }
    return ans;
    }
};