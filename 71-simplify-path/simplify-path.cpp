class Solution {
public:
    string simplifyPath(string path) {
         stack<string> s;
        string res, temp;
        stringstream ss(path);

        while (getline(ss, temp, '/'))
        {
            if (temp == "." || temp.empty())
                continue;
            else if (temp == "..")
            {
                if (!s.empty())
                    s.pop();
            }
            else
            {
                s.push(temp);
            }
        }

        while (!s.empty())
        {
            res = "/" + s.top() + res;
            s.pop();
        }

        return res.empty() ? "/" : res;
    }
};